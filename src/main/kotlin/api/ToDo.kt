package api

import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import models.RequestTodo
import utils.Mapper

object ToDo {

    fun getToDo(offset: Int = 0, limit: Int = 1000): List<RequestTodo> {
        val param = mapOf("offset" to offset,"limit" to limit)
        val response = spec().params(param).get().then().log()
            .all().statusCode(200).extract().body().asString()
        return Mapper.deserializationList(response)
    }

    fun createToDo(request: RequestTodo) {
        spec().contentType(ContentType.JSON).body(Mapper.serialization(request))
            .post().then().log().all().statusCode(201)
    }

    fun updateToDo(id: Int,request: RequestTodo) {
            spec().contentType(ContentType.JSON).body(Mapper.serialization(request)).put("/$id").then().log()
                .all().statusCode(200)
    }

    fun deleteToDo(id:Int) {
        spec().auth().preemptive().basic("admin", "admin").delete("/$id").then().log()
            .all().statusCode(204)
    }

    fun deleteToDoWithoutAuth(id:Int) {
        spec().delete("/$id").then().log()
            .all().statusCode(401)
    }

    fun spec() = given().baseUri("http://localhost:8080").basePath("/todos").log().all()

}