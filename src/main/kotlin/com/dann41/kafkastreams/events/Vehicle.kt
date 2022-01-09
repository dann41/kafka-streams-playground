package com.dann41.kafkastreams.events

import java.time.OffsetDateTime

data class Vehicle(
    val id: String,
    val licensePlate: String,
    val odometer: Long,
    val createdAt: OffsetDateTime
)