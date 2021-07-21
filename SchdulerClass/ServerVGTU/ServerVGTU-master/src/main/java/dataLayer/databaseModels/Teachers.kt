package dataLayer.databaseModels

import models.TeacherModel
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.SizedCollection
import org.jetbrains.exposed.sql.deleteWhere
import kotlin.math.min

object Teachers : IntIdTable() {
    val surname = varchar("surname", 50).nullable()
    val name = varchar("name", 50).nullable()
    val patronymic = varchar("patronymic", 50).nullable()
    val position = varchar("position", 100).nullable() //должность
    val degree = varchar("degree", 100).nullable() //Ученая степень
    val title = varchar("title", 100).nullable()//звание
    val imageUrl = varchar("image_url", 500).nullable()
    val url = varchar("url", 500).nullable()
}

class TeacherEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<TeacherEntity>(Teachers) {
        fun new(teacher: TeacherModel): TeacherEntity {
            val departments = teacher.departments?.map { Department.find { Departments.name eq it.name }.first() }
            val dbTeacher = new {
                surname = teacher.surname
                name = teacher.name
                patronymic = teacher.patronymic
                position = teacher.position
                degree = teacher.degree
                title = teacher.title
                imageUrl = teacher.imageUrl
                url = teacher.url
            }
            departments?.let { dbTeacher.departments = SizedCollection(it) }
            return dbTeacher
        }

        fun find(teacher: TeacherModel): TeacherEntity? {
            if (teacher.surname == null) return null
            if (teacher.name == null) println("ERROR TeacherEntity.find(teacher) could not recognize name: $teacher")
            if (teacher.patronymic == null) println("ERROR TeacherEntity.find(teacher) could not recognize patronymic $teacher")
            all().forEach {
                val nameModelLength = teacher.name?.replace(".", "")?.length!!
                val nameEntityLength = it.name?.replace(".", "")?.length!!
                val nameMinLength = min(nameModelLength,nameEntityLength)

                val patronymicModelLength = teacher.patronymic?.replace(".", "")?.length!!
                val patronymicEntityLength = it.patronymic?.replace(".", "")?.length!!
                val patronymicMinLength = min(patronymicModelLength,patronymicEntityLength)
             //   println("test nameLength:$nameLength \n ${it} \n\n ${teacher} ")
//                try {
                    if (it.surname?.toLowerCase() == teacher.surname?.toLowerCase()
                            && it.name?.toLowerCase()?.substring(0 until nameMinLength)
                            == teacher.name?.toLowerCase()?.substring(0 until nameMinLength)
                            && it.patronymic?.toLowerCase()?.substring(0 until patronymicMinLength)
                            == teacher.patronymic?.toLowerCase()?.substring(0 until patronymicMinLength)
                    ) return it
//                } catch (e: StringIndexOutOfBoundsException){
//                    println("test nameLength:$nameLength \n bdname ${it.name} \n\n name ${teacher} ")
//            //        exitProcess(555)
//                }
            }
            return new(teacher)
        }
    }

    var departments by Department via TeachersDepartments
    var surname by Teachers.surname
    var name by Teachers.name
    var patronymic by Teachers.patronymic
    var position by Teachers.position  //должность
    var degree by Teachers.degree //Ученая степень
    var title by Teachers.title //звание
    var imageUrl by Teachers.imageUrl
    var url by Teachers.url

    val model: TeacherModel
        get() {
            return TeacherModel(
                    surname,
                    name,
                    patronymic,
                    position,
                    degree,
                    title,
                    imageUrl,
                    url,
                    departments.map { it.model }.toList()
            )
        }

    override fun delete() {
        super.delete()
        TeachersDepartments.deleteWhere { TeachersDepartments.teacher eq id }
    }
}

