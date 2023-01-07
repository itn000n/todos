package todos.post

import api.ToDo
import models.RequestTodo
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import utils.Utils.getRandomId
import kotlin.test.assertEquals

class CreateToDoWithEmptyText {

    @DisplayName("Проверка создания задания с пустым текстом и флагом готовности в true")
    @Test
    fun createToDoWithEmptyText() {
        val id = getRandomId()
        val request = RequestTodo(id, "", true)
        ToDo.createToDo(request)
        val response = ToDo.getToDo()
        val result = response.find { it.id == id }
        assertEquals(result, request)
    }
}