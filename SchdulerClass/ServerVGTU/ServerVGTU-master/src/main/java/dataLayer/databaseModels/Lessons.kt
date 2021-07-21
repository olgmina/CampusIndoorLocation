package dataLayer.databaseModels

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.SizedCollection
import org.jetbrains.exposed.sql.deleteWhere

object Lessons : IntIdTable() {
    val studentGroupId = reference("studentGroup_id", StudentGroups)
    val name = varchar("name", 150).nullable()
    val type = varchar("type", 50).nullable()
    val starts = varchar("starts", 10).nullable()
    val duration = integer("duration").nullable()
    val subgroup = text("subgroup").nullable()
    val weekType = varchar("weekType", 15).nullable()
    val dayWeek = varchar("dayWeek", 20).nullable()
    val number = integer("number").nullable()
}

@Suppress("NAME_SHADOWING")
class Lesson(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Lesson>(Lessons) {
        const val SEPARATOR = "`"

        fun new(lesson: models.Lesson): Lesson {
            val studentGroupId = lesson.group?.name?.let { Group.find { StudentGroups.name eq it }.first().id }
            val dbLesson = new {
                this.studentGroupId = studentGroupId!!
                name = lesson.name
                type = lesson.type
                starts = lesson.starts
                duration = lesson.duration
                subgroup = lesson.subgroup?.toTypedArray()
                weekType = lesson.weekType
                dayWeek = lesson.dayWeek
                number = lesson.number
            }
            val rooms = lesson.rooms.let { lesson.rooms?.map { Room.find(it) } }
            rooms?.let { dbLesson.rooms = SizedCollection(it) }
            val teachers = lesson.teachers?.map { TeacherEntity.find(it)!! }
            teachers?.let { dbLesson.teachers = SizedCollection(it) }
            return dbLesson
        }


    }

    var studentGroupId by Lessons.studentGroupId
    var teachers by TeacherEntity via LessonsTeachers
    var name by Lessons.name
    var rooms by Room via LessonsRooms
    var type by Lessons.type
    var starts by Lessons.starts
    var duration by Lessons.duration
    var weekType by Lessons.weekType
    var dayWeek by Lessons.dayWeek
    var number by Lessons.number
    var subgroup by Lessons.subgroup.transform(
            { it?.joinToString(SEPARATOR) },
            { str -> str?.split(SEPARATOR)?.map { it.toIntOrNull() }?.toTypedArray() }
    )

    val model: models.Lesson
        get() {
            return models.Lesson(
                    teachers.map { teacher ->
                        models.TeacherModel(
                                teacher.surname,
                                teacher.name,
                                teacher.patronymic,
                                teacher.position,
                                teacher.degree,
                                teacher.title,
                                teacher.imageUrl,
                                teacher.url,
                                teacher.departments.map { it.model }
                        )
                    },
                    name,
                    rooms.map { models.Room(it.name) },
                    type,
                    subgroup?.filterNotNull(),
                    starts,
                    duration,
                    Group.findById(studentGroupId)?.model,
                    dayWeek,
                    number,
                    weekType
            )
        }

    fun update(lesson: models.Lesson) {
        if (type != lesson.type) type = lesson.type
        if (starts != lesson.starts) starts = lesson.starts
        if (duration != lesson.duration) duration = lesson.duration
        if (subgroup != lesson.subgroup) subgroup = lesson.subgroup?.toTypedArray()
        if (weekType != lesson.weekType) weekType = lesson.weekType
        if (dayWeek != lesson.dayWeek) dayWeek = lesson.dayWeek
        if (number != lesson.number) number = lesson.number
        if (studentGroupId != Group.find(lesson.group!!)?.id) studentGroupId = Group.find(lesson.group!!)?.id!!
        lesson.teachers?.let { teachers ->
            val teachers = SizedCollection(
                    teachers.map { TeacherEntity.find(it) }
                            .filter { it != null }
                            .map { it!! }
            )
            if (this.teachers.map { it.model } != teachers.map { it.model }) this.teachers = teachers
        }
        lesson.rooms?.let { roomsLessons ->
            val roomsLessons = SizedCollection(
                    roomsLessons.map { Room.find(it) }
            )
            if (rooms.map { it.model } != roomsLessons.map { it.model }) rooms = roomsLessons
        }
    }

    //crutch
    override fun delete() {
        super.delete()
        LessonsRooms.deleteWhere { LessonsRooms.lesson eq id}
        LessonsTeachers.deleteWhere { LessonsTeachers.lesson eq id}
    }

}
