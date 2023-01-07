package todos.get

import api.ToDo
import io.restassured.RestAssured.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import todos.BaseTest
import utils.Utils.createSomeToDos
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class GetAllWithLimit : BaseTest() {

    @DisplayName("Проверка получения списка заданий с заданным лимитом")
    @Test
    fun getAllWithLimit() {
        createSomeToDos()
        var countAllToDos = ToDo.getToDo().size
        assertNotEquals(countAllToDos, 0)
        while (countAllToDos != 0) {
            countAllToDos--
            val countToDos = ToDo.getToDo(limit = countAllToDos).size
            assertEquals(countToDos, countAllToDos)
        }
    }
}