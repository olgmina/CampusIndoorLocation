package models

data class Group(
        val name: String,
        val timetableUrl: String,
        val faculty: Faculty? = null
)