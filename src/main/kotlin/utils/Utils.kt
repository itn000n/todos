package utils

import api.ToDo
import models.RequestTodo

object Utils {
    fun getRandomId(): Int {
        var maxId: Int? = ToDo.getToDo().maxOfOrNull { it.id!! } ?: return 1
        return maxId!! + 1
    }

    fun createSomeToDos() {
        val countToDos = ToDo.getToDo().size
        if (countToDos < 100) {
            val id = getRandomId()
            for (i in id..id+100) {
                val req = RequestTodo(i, "test string $i", false)
                ToDo.createToDo(req)
            }
        }
    }
}