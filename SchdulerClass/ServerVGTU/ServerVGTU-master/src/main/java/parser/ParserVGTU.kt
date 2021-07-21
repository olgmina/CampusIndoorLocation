package parser

import models.*
import org.apache.poi.hwpf.HWPFDocument
import org.apache.poi.hwpf.usermodel.Paragraph
import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.jsoup.HttpStatusException
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.net.URL

@Suppress("NAME_SHADOWING")
class ParserVGTU {
    companion object {
        private const val HOST_NAME = "http://cchgeu.ru/"
        private const val FACULTIES_URL = HOST_NAME + "education/inst/"
        private const val SCHEDULE_URL = HOST_NAME + "education/schedule/"
        private const val DEPARTMENTS_URL = HOST_NAME + "education/cafedras/"
        private const val TIMEOUT = 100 * 1000
        private const val USER_AGENT_CHROME = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36"
        private const val USER_AGENT_FIREFOX = "Mozilla/5.0 (platform; rv:geckoversion) Gecko/geckotrail Firefox/firefoxversion"
        private const val REFERRER = "https://www.google.com"
        private const val SLEEP_TIME = 2 * 1000L

        private val dayOfWeekRegex = "(?:Пнд|Втр|Срд|Чтв|Птн|Сбт|Вс)<end cell>".toRegex()
        private val roomRegex = "(?:а?[. ]?)([ \\n]{0,3}[\\\\0-9/]{3,5}[а-я]?(?:[ \\n,]+[\\\\0-9/]{3,5}){0,10})".toRegex()
        private val subgroupRegex = "[-–]{0,2}[ \\n]?((?:[1-5]{1,2},)?(?:[1-5]{1,2}))[ \\\\n]{0,3}п/(?:г)?".toRegex()
        private val teacherRegex = "([А-Я]{2,10})[.](?:([А-я]{2,10})[.])?[ \\n]?([ЁА-я-]{2,30})[ \\n]([А-Я]{1,3})[.]{1,2}[ \\n]?([А-Я])[.]{0,2}".toRegex()
        private val startLessonRegex = "[Сс][ \\n]?([0-9]{1,2}(?:[ \\n]?-[ \\n]?[0-9]{1,2})?)[ \\n]?(нед\\.?|н\\.?)(?:(по([0-9]{1,2}))н[.]?)?".toRegex()
        private val durationRegex = "([0-9]{1,2})[ \\n]?(нед\\.|н\\.)".toRegex()
        private val teacherTitleRegex = "(([А-Я]{2,10})[.](?:([А-я]{2,10})[.])?)[ \\n]".toRegex()
        private val lessonTypeRegex = "([а-я]{2,5})\\.".toRegex()
        private const val END_CELL = "<end cell>"
        private const val NO_LESSON = "_"

        private fun jsoup(url: String): Document {
            Thread.sleep(SLEEP_TIME)
            return Jsoup.connect(url)
                    .userAgent(USER_AGENT_FIREFOX)
                    .referrer(REFERRER)
                    .timeout(TIMEOUT)
                    .get()
        }

        fun faculties(): List<Faculty> {
            val faculties = jsoup(FACULTIES_URL)
                    .getElementsByClass("middle")
                    .first()
                    .getElementsByTag("a")
                    .filter { it.hasAttr("id") }
                    .map { Faculty(it.text(), it.attr("abs:href"), facultyTimetableUrl(it.text())) }
                    .toList()
                    .toMutableList()
            faculties.addAll(facultiesFromScheduler())
            return faculties.toList()
        }

        fun facultiesFromScheduler(): List<Faculty> {
            val faculties = mutableListOf<Faculty>()
            jsoup(SCHEDULE_URL)
                    .getElementsByClass("table")
                    .first()
                    .getElementsByTag("tr")
                    .filter { it.getElementsByTag("a").size > 0 }
                    .map {
                        var name = ""
                        var url = ""
                        var timetableUrl = ""
                        it.getElementsByTag("a")
                                .forEach { href ->
                                    if (href.text().toLowerCase().contains("расписание")
                                            || href.attr("href").toLowerCase().contains("schedule")) {
                                        timetableUrl = href.attr("abs:href")
                                    } else {
                                        name = href.text()
                                        url = href.attr("abs:href")
                                    }
                                }
                        if (name != "") {
                            faculties.add(Faculty(name, url, timetableUrl))
                        }
                    }

            return faculties.toList()
        }

        fun faculties(departmentUrl: String): Faculty? {
            val faculties = jsoup(departmentUrl)
                    .getElementsByClass("content")
                    .first()
                    .getElementsByTag("a")
                    .asSequence()
                    .filter { it.text().toLowerCase().contains("факультет") || it.text().toLowerCase().contains("институт") }
                    .filter { it.attr("href").contains("education/") }
                    .filter { !it.hasAttr("class") }
                    .map { Faculty(it.text(), it.absUrl("href"), facultyTimetableUrl(it.text())) }
                    .toList()
            return if (faculties.isEmpty()) null else faculties.first()
        }

        fun departments(facultyUrl: String): List<Department>? {
            return try {
                jsoup("$facultyUrl?cafedras")
                        .getElementsByClass("cafedras")
                        ?.first()
                        ?.getElementsByTag("li")
                        ?.map { it.getElementsByAttribute("href") }
                        ?.map { Department(it.text(), it.attr("abs:href")) }
            } catch (e: HttpStatusException) {
                null
            }
        }

        fun departments(): List<Department> {
            val departments = jsoup("$DEPARTMENTS_URL?cafedras")
                    .getElementsByClass("middle")
                    .first()
                    .getElementsByTag("a")
                    .filter { it.hasAttr("id") }
                    .map { Department(it.text(), it.absUrl("href")) }
            departments.map { department ->
                department.faculty = department.url?.let { faculties(it) }
            }
            return departments
        }

        fun teachers(departmentUrl: String): List<TeacherModel>? {
            try {
                val teachers = jsoup("$departmentUrl?teachers")
                        .getElementsByClass("teachers")
                        ?.first()
                        ?.getElementsByClass("item")
                        ?.map { it.getElementsByAttribute("href") }
                        ?.map {
                            val imageUrl = HOST_NAME + it.attr("style")
                                    .replace("background: url(", "")
                                    .replace("); background-size: cover;", "")
                                    .substring(1)
                            val fioStr = it.text().trim()
                            var fio = fioStr.split(" ")
                            if (fio.size < 3) {
                                try {
                                    val initials = fio[1].split(".")
                                    if (initials.size < 2) {
                                        val regex = "(?=[А-Я])".toRegex()
                                        fio = fioStr.split(regex).map { it.trim() }.subList(1, 4)
                                    } else {
                                        fio = listOf(fio[0], initials[0], initials[1])
                                    }
                                } catch (e: IndexOutOfBoundsException){
                                    println(f)
                                }
                            }
                            TeacherModel(
                                    surname = fio[0],
                                    name = fio[1],
                                    patronymic = fio[2],
                                    url = it.attr("abs:href"),
                                    imageUrl = imageUrl
                            )
                        }
                teachers?.forEach { teacher ->
                    try {
                        val html = teacher.url?.let { it1 ->
                            jsoup(it1)
                                    .getElementsByClass("employee-detail")
                                    .first()
                                    .getElementsByTag("h5")
                        }
                        val positionRegex = "<b>Должность:</b>([ А-я.-]{2,})".toRegex()
                        val degreeRegex = "<b>Ученая степень:</b>([ А-я.-]{2,})".toRegex()
                        val titleRegex = "<b>Ученое звание:</b>([ А-я.-]{2,})".toRegex()
                        teacher.position = positionRegex.find(html.toString())?.groupValues?.get(1)?.trim()
                        teacher.degree = degreeRegex.find(html.toString())?.groupValues?.get(1)?.trim()
                        teacher.title = titleRegex.find(html.toString())?.groupValues?.get(1)?.trim()
                    } catch (ignored: HttpStatusException) {
                    }
                }
                return teachers
            } catch (e: HttpStatusException) {
                return null
            }
        }

        // timetable url from faculty ( .doc only )
        fun studentGroups(timetablesUrl: String): List<Group> {
            return jsoup(timetablesUrl)
                    .getElementsByClass("docs pane")
                    .asSequence()
                    // .filter { it.text().contains("весенний") }
                    .filter { it.text().contains("осенний") }
                    .map { it.getElementsByTag("a") }
                    .flatten()
                    .filter {
                        "[0-9А-я]+.(doc)".toRegex().containsMatchIn(it.text())
                                && !"[0-9А-я]+.(docx)".toRegex().containsMatchIn(it.text()) // .doc only
                    }.map {
                        Group(
                                it.text().replace(".doc", ""),
                                it.attr("abs:href")
                        )
                    }.toList()
        }

        fun lessons(timetableUrl: String): List<Lesson> {
            return lessonsFromDoc(timetableUrl)
        }


        fun lessonsFromDoc(timetableUrl: String): List<Lesson> {
            val inStream = URL(timetableUrl).openConnection().getInputStream()
            val doc = HWPFDocument(inStream)
            val paragraphs = mutableListOf<Paragraph>()
            for (i in 0 until doc.range.numParagraphs()) {
                paragraphs.add(doc.range.getParagraph(i))
            }
            var tmp = paragraphs
                    .asSequence()
                    .filter { it.isInTable }
                    .map { it.text() }
                    .map { it.replace("\u0007", END_CELL) }
                    .filter { it.trim() != END_CELL }
                    .toList()
            var tmpStr = ""
            tmp.subList(16, tmp.size)
                    .forEach { tmpStr += it.replace("\r", "") }
            tmp = tmpStr.split(dayOfWeekRegex)
            val timetableStr = tmp.subList(1, tmp.size)
                    .map {
                        val item = it.split(END_CELL).toMutableList()
                        item.removeAt(item.size - 1)
                        item.toList()
                    }
            return lessonsFromStringTable(timetableStr)
        }

        private fun lessonsFromStringTable(timetableStr: List<List<String>>): List<Lesson> {
            val lessons = mutableListOf<Lesson>()
            for (dayOfWeek in 0 until timetableStr.size) {
                for (lessonNumber in 0 until timetableStr[dayOfWeek].size) {
                    var lessonsStr = timetableStr[dayOfWeek][lessonNumber].trim()
                    if (lessonsStr == NO_LESSON) continue
                    if (subgroupRegex.containsMatchIn(lessonsStr)) {
                        while (roomRegex.containsMatchIn(lessonsStr)) {
                            val startNextLessonStr = roomRegex.find(lessonsStr)?.range?.last?.plus(1)
                            startNextLessonStr?.let {
                                val oneLessonStr = lessonsStr.substring(0, it)
                                val lesson = lessonFromString(oneLessonStr)
                                lesson.weekType = weekType(dayOfWeek)
                                lesson.dayWeek = dayOfWeekFrom(dayOfWeek)
                                lesson.number = lessonNumber + 1
                                lessons.add(lesson)
                                lessonsStr = lessonsStr.substring(it, lessonsStr.length).trim()
                            }
                        }
                    } else {
                        val lesson = lessonFromString(lessonsStr)
                        lessons.add(lesson)
                        lesson.weekType = weekType(dayOfWeek)
                        lesson.dayWeek = dayOfWeekFrom(dayOfWeek)
                        lesson.number = lessonNumber + 1
                        lessons.add(lesson)
                    }
                }
            }
            return lessons.distinct()
        }

        private fun lessonFromString(lessonStr: String): Lesson {
            var lessonStr = lessonStr
            val rooms = roomRegex.findAll(lessonStr).map { roomMatch ->
                lessonStr = lessonStr.replace(roomMatch.value, "")
                val rooms = roomMatch.groupValues[1]
                        .trim()
                        .replace("[ \n]+".toRegex(), " ")
                        .replace(" ,|, ", ",")
                        .split("[, \n]".toRegex())
                rooms
            }.flatten().map { Room(it) }.toList()
            val subgroup = subgroupRegex.findAll(lessonStr).map { subgroupMatch ->
                lessonStr = lessonStr.replace(subgroupMatch.value, "")
                subgroupMatch.groupValues[1].split(",")
            }.flatten()
                    .map { it.chunked(1) }
                    .flatten()
                    .map { it.toInt() }
                    .toList()
            val teachers = teacherRegex.findAll(lessonStr).map { teacherMatch ->
                var teacherMatcherValue = teacherMatch.value
                val teacherTitle = teacherMatcherValue.let {
                    val teacherTitleMatcher = teacherTitleRegex.find(it)
                    lessonStr = lessonStr.replace(teacherMatcherValue, "")
                    teacherMatcherValue = it.replace(teacherTitleMatcher?.value.toString(), "")
                    teacherTitleMatcher?.groupValues?.get(1)
                }
                val teacherSurname = teacherMatcherValue.split(" ")[0]
                val teacherInitial = teacherMatcherValue.split(" ")[1]
                val teacherName = teacherInitial.split(".")[0]
                val teacherPatronymic = teacherInitial.split(".")[1]
                TeacherModel(
                        teacherSurname,
                        teacherName,
                        teacherPatronymic,
                        title = teacherTitle
                )
            }.toList()
            val startsLesson = startLessonRegex.find(lessonStr)?.groupValues?.let {
                lessonStr = lessonStr.replace(it[0], "")
                it[1] + it[3].replace("по", "-")
            }
            val lessonDuration = durationRegex.find(lessonStr)?.groupValues?.let {
                lessonStr = lessonStr.replace(it[0], "")
                it[1]
            }
            val lessonType = lessonTypeRegex.find(lessonStr)?.groupValues?.let {
                lessonStr = lessonStr.replace(it[0], "")
                it[1]
            }
            val lessonName = clearNameLesson(lessonStr)
            return Lesson(
                    teachers,
                    lessonName,
                    rooms,
                    lessonType,
                    subgroup,
                    startsLesson,
                    lessonDuration?.toIntOrNull()
            )
        }

        //dont work "Факультет довузовского и дополнительного обучения" because difference names
        private fun facultyTimetableUrl(nameFaculty: String): String? {
            jsoup(HOST_NAME + "education/schedule/")
                    .getElementsByClass("table")
                    .first()
                    .getElementsByTag("tr")
                    .map { tr ->
                        tr.getElementsByTag("a").forEach { a ->
                            if (a.text().trim().toLowerCase() == nameFaculty.trim().toLowerCase()) {
                                return HOST_NAME + tr.getElementsByAttribute("id")
                                        .attr("href")
                                        .substring(1)
                            }
                        }
                    }
            return null
        }

        private fun dayOfWeekFrom(number: Int): String {
            return when (number % 6) {
                0 -> "Понедельник"
                1 -> "Вторник"
                2 -> "Среда"
                3 -> "Четверг"
                4 -> "Пятница"
                5 -> "Суббота"
                else -> "error"
            }
        }

        private fun weekType(dayNumber: Int?): String {
            return when (dayNumber) {
                in 0..5 -> "Числитель"
                in 6..11 -> "Знаменатель"
                else -> "error"
            }
        }

        private fun clearNameLesson(nameLesson: String): String {
            var newName = nameLesson.replace("[ \n]+".toRegex(), " ").trim()
            newName = alignDash(newName)
            newName = newName.replace("(", " (")
            newName = newName.replace("( ", "(")
            newName = newName.replace(" )", ")")
            newName = newName.replace(")", ")")
            if (!newName.contains('(') && newName.contains(')')) newName = newName.replace(")", "")
            if (!newName.contains(')') && newName.contains('(')) newName = newName.replace(")", "")
            newName = newName.trim('\n', ' ', '-', '_', ',', '.').replace("[ \n]+".toRegex(), " ")
            return newName
        }

        private fun alignDash(text: String): String {
            var newText = text
            if (newText.contains("-")) {
                newText = newText.replace("[ ]?-[ ]?".toRegex(), "-")
                val words = newText.split(" ").toMutableList()
                for (i in 0 until words.size) {
                    if (words[i].contains("-")
                            && words[i].split("-")[0].length > 4
                            && words[i].split("-")[1].length > 4
                    ) {
                        words[i] = words[i].replace("-", " - ")
                        newText = ""
                        words.forEach { newText += it + " " }
                        return newText
                    }
                }
            }
            return text
        }
    }
}
