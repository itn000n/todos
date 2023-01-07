package todos.get

import api.ToDo
import io.restassured.RestAssured.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import todos.BaseTest
import kotlin.test.assertNotEquals

class GetAll: BaseTest() {

    @DisplayName("Проверка получения списка заданий")
    @Test
    fun getAll() {
        val response = ToDo.getToDo()
        assertNotEquals(response.size, 0)
    }
}