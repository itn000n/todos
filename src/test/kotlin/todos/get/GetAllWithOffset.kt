package todos.get

import api.ToDo
import io.restassured.RestAssured.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import todos.BaseTest
import utils.Utils.createSomeToDos
import kotlin.test.assertNotEquals

class GetAllWithOffset : BaseTest() {

    @DisplayName("Проверка получения списка заданий с заданным offset")
    @Test
    fun getAllWithOffset() {
        createSomeToDos()
        var countAllToDos = ToDo.getToDo().size
        assertNotEquals(countAllToDos, 0)
        var countToDos = 0
        var id = 0
        while (countAllToDos - 1 != countToDos) {
            countToDos++
            val result = ToDo.getToDo(limit = 1, offset = countToDos)[0].id!!
            assertNotEquals(result, id)
            id = result
        }
    }
}