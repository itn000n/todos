package todos.delete

import api.ToDo
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import utils.Utils

class DeleteToDoNotAuth {

    @DisplayName("Проверка удаления задания без авторизации")
    @Test
    fun deleteToDo() {
        Utils.createSomeToDos()
        val id = ToDo.getToDo()[0].id
        ToDo.deleteToDoWithoutAuth(id!!)
    }
}