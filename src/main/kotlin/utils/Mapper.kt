package utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

object Mapper {

    inline fun <reified T>deserializationList (
        text: String,
    ): T {
        val mapper = ObjectMapper()
        return mapper.readValue(text)
    }

    fun <T> serialization(
        listOfObjects: T,
    ): String {
        val mapper = ObjectMapper();
        return mapper.writeValueAsString(listOfObjects)
    }
}