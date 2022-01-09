package com.dann41.kafkastreams.exceptions

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.streams.errors.DeserializationExceptionHandler
import org.apache.kafka.streams.processor.ProcessorContext
import java.lang.Exception

class SkipRecordDeserializationExceptionHandler : DeserializationExceptionHandler {
    override fun configure(configs: MutableMap<String, *>?) {

    }

    override fun handle(
        context: ProcessorContext?,
        record: ConsumerRecord<ByteArray, ByteArray>?,
        exception: Exception?
    ): DeserializationExceptionHandler.DeserializationHandlerResponse {
        println("Deserialization Exception with message: ${exception?.message}")
        return DeserializationExceptionHandler.DeserializationHandlerResponse.CONTINUE
    }
}