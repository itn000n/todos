package todos.post

import api.ToDo
import models.RequestTodo
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import utils.Utils.getRandomId
import kotlin.test.assertEquals

class CreateToDo {

    @DisplayName("Проверка создания задания")
    @Test
    fun createToDo() {
        val id = getRandomId()
        val request = RequestTodo(id, "test", false)
        ToDo.createToDo(request)
        val response = ToDo.getToDo()
        val result = response.find { it.id == id }
        assertEquals(result, request)
    }
}