package dataLayer.databaseModels

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object Rooms : IntIdTable() {
    val name = varchar("name", 10)
}

class Room(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Room>(Rooms) {
        fun new(room: models.Room): Room {
            return new {
                name = room.name
            }
        }

        fun find(room: models.Room): Room {
            val dbRoom = find { Rooms.name eq room.name }.firstOrNull()
            return dbRoom ?: new(room)
        }
    }

    var name by Rooms.name

    val model: models.Room
        get() {
            return models.Room(name)
        }
}