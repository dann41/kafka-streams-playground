package com.dann41.kafkastreams.serdes

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.common.serialization.Serializer


class JsonSerde<T>(
    clazz: Class<T>,
    objectMapper: ObjectMapper
) : Serdes.WrapperSerde<T>(JsonSerializer<T>(objectMapper), JsonDeserializer(objectMapper, clazz))

class JsonSerializer<T>(private val objectMapper: ObjectMapper) : Serializer<T> {
    override fun serialize(topic: String?, data: T): ByteArray {
        return try {
            objectMapper.writeValueAsBytes(data)
        } catch (e: Exception) {
            throw SerializationException("Error serializing JSON message", e)
        }
    }
}

class JsonDeserializer<T>(private val objectMapper: ObjectMapper,
                          private val clazz: Class<T>) : Deserializer<T> {
    override fun deserialize(topic: String?, data: ByteArray?): T? {
        try {
            if (data == null || data.isEmpty()) {
                return null
            }
            return objectMapper.readValue(data, clazz)
        } catch (e: Exception) {
            throw SerializationException(e)
        }
    }
}