package models

data class Department(
        var name: String,
        var url: String? = null,
        var faculty: Faculty? = null
)