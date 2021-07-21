package models

data class Lesson(
        var teachers: List<TeacherModel>? = null,
        var name: String?,
        var rooms: List<Room>? = null,
        var type: String? = null,
        var subgroup: List<Int>? = null,
        var starts: String? = null,
        var duration: Int? = null,
        var group: Group? = null,
        var dayWeek: String? = null,
        var number: Int? = null,
        var weekType: String? = null
)