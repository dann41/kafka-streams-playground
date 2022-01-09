package com.dann41.kafkastreams.events

data class VehiclePhoto(
    val id: String,
    val vehicle: String,
    val photoUrl: String,
    val order: Int
)