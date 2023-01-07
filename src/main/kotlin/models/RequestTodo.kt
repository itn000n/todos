package models

data class RequestTodo(
    var id: Int? = null,
    var text: String? = null,
    var completed: Boolean = false
)