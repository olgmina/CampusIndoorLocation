package dataLayer.databaseModels

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption

object LessonsTeachers: IntIdTable() {
    val lesson = reference("lesson_id",Lessons,onDelete = ReferenceOption.CASCADE)
    val teacher = reference("teacher_id",Teachers,onDelete = ReferenceOption.CASCADE)

}