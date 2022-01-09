package com.dann41.kafkastreams.events

import java.time.OffsetDateTime

data class VehiclePrice(
    val id: String,
    val price: Long,
    val createdAt: OffsetDateTime
)