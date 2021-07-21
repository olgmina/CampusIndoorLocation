package dataLayer

import dataLayer.databaseModels.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.Connection
import java.sql.ResultSet

object DatabaseVGTU {
    init {
        Database.connect("jdbc:sqlite:databaseVGTY.sqlite", driver = "org.sqlite.JDBC")
        TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE
        transaction { "PRAGMA foreign_keys = ON".execAndMap {} }
    }

    fun createSchema() {
        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(
                    Rooms,
                    Faculties,
                    Departments,
                    Teachers,
                    TeachersDepartments,
                    StudentGroups,
                    Lessons,
                    LessonsTeachers,
                    LessonsRooms
            )
        }
    }

    fun deleteSchema() {
        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.drop(
                    Rooms,
                    Faculties,
                    Departments,
                    Teachers,
                    TeachersDepartments,
                    StudentGroups,
                    Lessons,
                    LessonsTeachers,
                    LessonsRooms
            )
        }
    }


    fun <T : Any> String.execAndMap(transform: (ResultSet) -> T): List<T> {
        val result = arrayListOf<T>()
        TransactionManager.current().exec(this) { rs ->
            while (rs.next()) {
                result += transform(rs)
            }
        }
        return result
    }
}