package dataLayer.databaseModels

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption

object TeachersDepartments : IntIdTable() {
    val teacher = reference("teacher", Teachers,onDelete = ReferenceOption.CASCADE)
    val department = reference("department", Departments,onDelete = ReferenceOption.CASCADE)
}