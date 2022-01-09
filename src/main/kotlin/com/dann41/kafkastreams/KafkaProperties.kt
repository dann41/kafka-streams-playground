package com.dann41.kafkastreams

import com.dann41.kafkastreams.exceptions.SkipRecordDeserializationExceptionHandler
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsConfig
import java.util.*

object KafkaProperties {

    val properties: Properties = Properties()

    init {
        properties[StreamsConfig.APPLICATION_ID_CONFIG] = "kafka-streams-playground"
        properties[StreamsConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        properties[StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG] = Serdes.String()::class.java
        properties[StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG] = Serdes.String()::class.java
        properties[StreamsConfig.DEFAULT_DESERIALIZATION_EXCEPTION_HANDLER_CLASS_CONFIG] = SkipRecordDeserializationExceptionHandler::class.java
        properties[StreamsConfig.COMMIT_INTERVAL_MS_CONFIG] = 100
    }

}