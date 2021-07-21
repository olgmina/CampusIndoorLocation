package dataLayer.databaseModels

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption

object LessonsRooms : IntIdTable() {
    val lesson = reference("lesson_id", Lessons,onDelete = ReferenceOption.CASCADE)
    val room = reference("room_id", Rooms,onDelete = ReferenceOption.CASCADE)
}