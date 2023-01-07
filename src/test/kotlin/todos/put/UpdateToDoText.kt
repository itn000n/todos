package todos.put

import api.ToDo
import models.RequestTodo
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import utils.Utils
import kotlin.test.assertEquals

class UpdateToDoText {

    @DisplayName("Проверка обновления текста задания")
    @Test
    fun updateToDoText() {
        val id = Utils.getRandomId()
        val request = RequestTodo(id, "test", false)
        ToDo.createToDo(request)
        var response = ToDo.getToDo()
        var result = response.find { it.id == id }
        assertEquals(result, request)
        request.text = "true"
        ToDo.updateToDo(id, request)
        response = ToDo.getToDo()
        result = response.find { it.id == id }
        assertEquals(result, request)
    }
}