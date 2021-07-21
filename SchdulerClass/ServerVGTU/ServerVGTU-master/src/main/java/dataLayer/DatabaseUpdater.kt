package dataLayer

import dataLayer.databaseModels.*
import logger.Logger
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import parser.ParserVGTU
import java.io.FileNotFoundException
import java.io.IOException

object DatabaseUpdater : Thread() {

    private const val UPDATE_FREQUENCY = 60 * 60 * 1000L // 1 hour

    private const val TAG = "DATABASE_UPDATER_TAG"

    override fun run() {
        while (true) {
            try {
               /* updateFaculties()
                Logger.log(TAG, "faculties updated")
                updateDepartments()
                Logger.log(TAG, "departments updated")*/
                updateTeachers()
                Logger.log(TAG, "teachers updated")
                updateStudentGroups()
                Logger.log(TAG, "groups updated")
                updateLessons()
                Logger.log(TAG, "lessons updated")
                sleep(UPDATE_FREQUENCY)
            } catch (e: Exception) {
                Logger.e(TAG, e)
                e.printStackTrace()
            }
        }
    }

    fun updateFaculties() {
        transaction {
            // addLogger(StdOutSqlLogger)
            ParserVGTU.faculties().forEach { parsedFaculty ->
                val itFacultyQuery = Op.build { Faculties.name eq parsedFaculty.name }
                val dbFaculties = Faculties.select { Faculties.name eq parsedFaculty.name }
                if (dbFaculties.empty()) {
                    Faculties.insert {
                        it[name] = parsedFaculty.name
                        it[url] = parsedFaculty.url
                        it[timetablesUrl] = parsedFaculty.timetablesUrl
                    }
                } else {
                    val dbFaculty = dbFaculties.first()
                    if (dbFaculty[Faculties.url] != parsedFaculty.url) {
                        Faculties.update({ itFacultyQuery }) {
                            it[url] = parsedFaculty.url
                        }
                    }
                    if (dbFaculty[Faculties.timetablesUrl] != parsedFaculty.timetablesUrl) {
                        Faculties.update({ itFacultyQuery }) {
                            it[timetablesUrl] = parsedFaculty.timetablesUrl
                        }
                    }
                }
            }
        }
    }

    fun updateDepartments() {
        updateDepartmentsFromFaculty()
        updateDepartmentsFromDepatmentsList()
    }

    fun updateDepartmentsFromFaculty() {
        transaction {
            Faculty.all().forEach { faculty ->
                ParserVGTU.departments(faculty.url)?.forEach { newDepartment ->
                    val dbDepartments = Department.find { Departments.name eq newDepartment.name }
                    if (dbDepartments.empty()) {
                        Department.new {
                            name = newDepartment.name
                            url = newDepartment.url
                            facultyId = faculty.id
                        }
                    } else {
                        dbDepartments.forEach { dbDepartment ->
                            if (dbDepartment.url != newDepartment.url) dbDepartment.url = newDepartment.url
                            if (dbDepartment.facultyId != faculty.id) dbDepartment.facultyId = faculty.id
                        }
                    }
                }
            }
        }
    }

    fun updateDepartmentsFromDepatmentsList() {
        transaction {
            ParserVGTU.departments().forEach { newDepartment ->
                val dbDepartments = Department.find { Departments.name eq newDepartment.name }
                val newFacultyId = newDepartment.faculty?.name?.let {
                    Faculty.find { Faculties.name eq it }.first().id
                }
                if (dbDepartments.empty()) {
                    Department.new {
                        name = newDepartment.name
                        url = newDepartment.url
                        facultyId = newFacultyId
                    }
                } else {
                    dbDepartments.forEach { dbDepartment ->
                        if (dbDepartment.url != newDepartment.url) dbDepartment.url = newDepartment.url
                        if (dbDepartment.facultyId != newFacultyId) dbDepartment.facultyId = newFacultyId
                    }
                }
            }
        }
    }

    fun updateTeachers() {
        transaction {
            //   addLogger(StdOutSqlLogger)
            Department.all().forEach { department ->
                department.url?.let { departmentUrl ->
                    ParserVGTU.teachers(departmentUrl)?.forEach { newTeacher ->
                        val dbTeachers = TeacherEntity.find {
                            Teachers.surname eq newTeacher.surname and
                                    (Teachers.name eq newTeacher.name) and
                                    (Teachers.patronymic eq newTeacher.patronymic)
                        }
                        val newDepartment = Department.findById(department.id)
                        newDepartment?.let {
                            newTeacher.departments = listOf(newDepartment.model)
                        }
                        if (dbTeachers.empty()) TeacherEntity.new(newTeacher)
                        else {
                            with(dbTeachers.first()) {
                                if (surname != newTeacher.surname) surname = newTeacher.surname
                                if (name != newTeacher.name) name = newTeacher.name
                                if (patronymic != newTeacher.patronymic) patronymic = newTeacher.patronymic
                                if (position != newTeacher.position) position = newTeacher.position  //должность
                                if (degree != newTeacher.degree) degree = newTeacher.degree //Ученая степень
                                if (title != newTeacher.title) title = newTeacher.title //звание
                                if (imageUrl != newTeacher.imageUrl) imageUrl = newTeacher.imageUrl
                                if (url != newTeacher.url) url = newTeacher.url
                                //dont delete old departments
                                if (!departments.contains(newDepartment)) {
                                    departments = SizedCollection(departments.toMutableList().apply {
                                        add(newDepartment!!)
                                    })
                                }
                            }
                        }
                        commit()
                    }
                }
            }
        }
    }

    fun updateStudentGroups() {
        transaction {
            //addLogger(StdOutSqlLogger)
            Faculty.all().forEach { faculty ->
                faculty.timetablesUrl?.let {
                    ParserVGTU.studentGroups(it).forEach { newStudentGroup ->
                        val dbStudentGroup = Group.find { StudentGroups.name eq newStudentGroup.name }
                        if (dbStudentGroup.empty()) {
                            Group.new {
                                name = newStudentGroup.name
                                timetableUrl = newStudentGroup.timetableUrl
                                facultyId = faculty.id
                            }
                        } else {
                            dbStudentGroup.forEach { it ->
                                if (it.timetableUrl != newStudentGroup.timetableUrl) {
                                    it.timetableUrl = newStudentGroup.timetableUrl
                                }
                                if (it.facultyId != faculty.id) {
                                    it.facultyId = faculty.id
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    @Deprecated(message = "incorrect work")
    fun updateLessonsWithNotify() {
        transaction {
            Group.all().forEach { studentGroup ->
                val query = Lessons.innerJoin(StudentGroups)
                        .select { Lessons.studentGroupId eq StudentGroups.id and (StudentGroups.name eq studentGroup.name) }
                val dbLessons = Lesson.wrapRows(query)
                if (studentGroup.name == "Б2331") {
                    println("w")
                } else println(studentGroup.name)
                val newLessons = ParserVGTU.lessons(studentGroup.timetableUrl)
                newLessons.map { it.group = studentGroup.model }
                dbLessons.forEach { dbLesson ->
                    val newLessonAtTime = getLessonAtTime(newLessons, dbLesson)
                    if (newLessonAtTime == null) dbLesson.delete()
                    else {
                        if (dbLesson.model.name != newLessonAtTime.name) { //delete old and insert new
                            dbLesson.delete()
                            Lesson.new(newLessonAtTime)
                        } else {
                            dbLesson.update(newLessonAtTime)
                        }
                    }
                }
                newLessons.forEach { newLesson ->
                    if (!dbLessons.map { it.number to it.dayWeek to it.weekType }
                                    .contains(newLesson.number to newLesson.dayWeek to newLesson.weekType)
                    ) Lesson.new(newLesson)
                }
                commit()
            }
        }
    }

    fun updateLessons() {
        transaction {
            Group.all().forEach { studentGroup ->
                try {
                    val query = (Lessons innerJoin StudentGroups)
                            .select { StudentGroups.name.eq(studentGroup.name) and Lessons.studentGroupId.eq(StudentGroups.id) }
                    Lesson.wrapRows(query).forEach { oldLesson -> oldLesson.delete() }
                    val newLessons = ParserVGTU.lessons(studentGroup.timetableUrl)
                    newLessons.map { it.group = studentGroup.model }
                    newLessons.forEach { newLesson -> Lesson.new(newLesson) }
                    commit()
                    Logger.log(TAG,"group updated: ${studentGroup.model.name}")
                } catch (e: IOException) {
                    when (e) {
                        is FileNotFoundException -> Logger.log(TAG, "group not found during update lesson: ${studentGroup.name}")
                        else -> Logger.e(TAG, e)
                    }
                }
            }
        }
    }

    fun getLessonAtTime(modelLessons: List<models.Lesson>, dbLesson: Lesson): models.Lesson? {
        modelLessons.map {
            if (it.number == dbLesson.number &&
                    it.dayWeek == dbLesson.dayWeek &&
                    it.weekType == dbLesson.weekType
            ) return it
        }
        return null
    }

}
