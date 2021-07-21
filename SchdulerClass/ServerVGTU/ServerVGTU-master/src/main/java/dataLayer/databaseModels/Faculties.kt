package dataLayer.databaseModels

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object Faculties : IntIdTable() {
    val name = varchar("name", 150)
    val timetablesUrl = varchar("timetables_url", 500).nullable()
    val url = varchar("url", 500)
}

class Faculty(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Faculty>(Faculties){
        fun find(faculty: models.Faculty): Faculty? {
            return find { Faculties.name eq faculty.name }.firstOrNull()
        }
    }

    var name by Faculties.name
    var timetablesUrl by Faculties.timetablesUrl
    var url by Faculties.url

    val model: models.Faculty
        get() {
            return models.Faculty(name, url, timetablesUrl)
        }
}
