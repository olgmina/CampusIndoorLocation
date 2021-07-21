package dataLayer.databaseModels

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object StudentGroups : IntIdTable() {
    val facultyId = reference("faculty_id", Faculties)
    val name = varchar("name", 100)
    val timetableUrl = varchar("timetable_url", 500)
}


class Group(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Group>(StudentGroups) {
        fun find(group: models.Group): Group? {
            return find { StudentGroups.name eq group.name }.firstOrNull()
        }
    }

    var name by StudentGroups.name
    var facultyId by StudentGroups.facultyId
    var timetableUrl by StudentGroups.timetableUrl

    val model: models.Group
        get() {
            val faculty = Faculty[facultyId].model
            return models.Group(name, timetableUrl,faculty)
        }


}

