package todos.delete

import api.ToDo
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DeleteToDo {

    @DisplayName("Проверка удаления задания")
    @Test
    fun deleteToDo() {
        val id = ToDo.getToDo()[0].id
        ToDo.deleteToDo(id!!)

        val response = ToDo.getToDo()
        val result = response.find { it.id == id }

        assertNull(result)
    }
}