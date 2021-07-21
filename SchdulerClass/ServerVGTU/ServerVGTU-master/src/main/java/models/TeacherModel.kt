package models

data class TeacherModel(
        var surname: String?,
        var name: String?,
        var patronymic: String?,
        var position: String? = null,//Должность
        var degree: String? = null,//Ученая степень
        var title: String? = null,//Звание
        var imageUrl: String? = null,
        var url: String? = null,
        var departments: List<Department>? = null
)