package com.dann41.kafkastreams.events

data class FullVehicle(
    val id: String,
    val vehicle: Vehicle,
    val price: VehiclePrice,
    val photos: List<VehiclePhoto>
){
    init {
        //require(photos.size >= 2) { "vehicle must have at least 2 photos" }
    }
}