package dataLayer.databaseModels

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object Departments : IntIdTable() {
    val facultyId = reference("faculty_id", Faculties).nullable()
    val name = varchar("name", 150)
    val url = varchar("url", 500).nullable()
}

class Department(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Department>(Departments){
        fun find(department: models.Department): Department? {
            return find { Departments.name eq department.name }.firstOrNull()
        }
    }

    var facultyId by Departments.facultyId
    var name by Departments.name
    var url by Departments.url

    val model: models.Department
        get() {
            return models.Department(
                    name,
                    url,
                    facultyId?.let { Faculty.findById(it)?.model }
            )
        }
}