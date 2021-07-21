package server

import dataLayer.databaseModels.*
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.route
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.andWhere
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

object Server : Thread() {
    override fun run() {
        //TODO Port
        val server = embeddedServer(Netty, port = 8080) {
            install(ContentNegotiation) {
                gson {
                    setPrettyPrinting()
                }
            }

            routing {
                get("/rooms") {
                    call.respond(transaction {
                        Room.all().map { it.model }.toList()
                    })
                }

                get("/rooms/{name}") {
                    call.parameters["name"]?.let { name ->
                        call.respond(transaction { Room.find(models.Room(name)).model })
                    }
                }

                get("/departments") {
                    call.respond(transaction {
                        Department.all().map { it.model }.toList()
                    })
                }

                get("/departments/{name}") {
                    call.parameters["name"]?.let { name ->
                        val department = transaction { Department.find(models.Department(name))?.model }
                        department?.let { call.respond(it) }
                    }
                }

                get("/faculties") {
                    call.respond(transaction {
                        Faculty.all().map { it.model }.toList()
                    })
                }

                get("/faculties/{name}") {
                    call.parameters["name"]?.let { name ->
                        val faculty = transaction { Faculty.find(models.Faculty(name, ""))?.model }
                        faculty?.let { call.respond(it) }
                    }
                }

                get("/groups") {
                    call.respond(transaction {
                        Group.all().map { it.model }.toList()
                    })
                }

                get("/groups/{name}") {
                    call.parameters["name"]?.let { name ->
                        val group = transaction { Group.find(models.Group(name, ""))?.model }
                        group?.let { call.respond(it) }
                    }
                }

                get("teachers") {
                    call.respond(transaction { TeacherEntity.all().map { it.model }.toList() })

                }

                get("teachers/{fullName}") {
                    call.parameters["fullName"]?.let { fullName ->
                        val (surname, name, patronymic) = fullName.split(" ")
                        call.respond(transaction {
                            TeacherEntity.find {
                                Teachers.surname eq surname and (
                                        Teachers.name eq name) and (
                                        Teachers.patronymic eq patronymic)
                            }.map { it.model }.first()
                        })
                    }
                }

                route("lessons") {
                    route("groups") {
                        route("{name}") {
                            get {
                                call.parameters["name"]?.let { groupName ->
                                    val query = Lessons.innerJoin(StudentGroups)
                                            .select { Lessons.studentGroupId eq StudentGroups.id and (StudentGroups.name eq groupName) }
                                    call.respond(transaction {
                                        Lesson.wrapRows(query).map { it.model }
                                    })
                                }
                            }
                        }
                    }
                    route("teachers") {
                        route("{fullName}") {
                            get {
                                call.parameters["fullName"]?.let { fullName ->
                                    val (surname, name, patronymic) = fullName.split(" ")
                                    val query = Lessons.innerJoin(LessonsTeachers).innerJoin(Teachers)
                                            .select {
                                                Lessons.id eq LessonsTeachers.lesson and (
                                                        LessonsTeachers.teacher eq Teachers.id) and (
                                                        Teachers.surname eq surname) and (
                                                        Teachers.name eq name) and (
                                                        Teachers.patronymic eq patronymic)
                                            }
                                    call.respond(transaction {
                                        Lesson.wrapRows(query).map { it.model }
                                    })
                                }
                            }
                        }
                    }
                    route("rooms") {
                        route("{name}") {
                            get {
                                call.parameters["name"]?.let { roomName ->
                                    val query = Lessons.innerJoin(LessonsRooms).innerJoin(Rooms)
                                            .select {
                                                Lessons.id eq LessonsRooms.lesson
                                            }.andWhere {
                                                LessonsRooms.room eq Rooms.id
                                            }.andWhere { Rooms.name eq roomName }
                                    call.respond(transaction {
                                        Lesson.wrapRows(query).map { it.model }
                                    })
                                }
                            }

                        }
                    }
                }
            }
        }
        server.start(wait = true)
    }


}