package com.dann41.kafkastreams.events

import com.fasterxml.jackson.annotation.JsonIgnore

data class PartialVehicle (
    val id: String,
    val vehicle: Vehicle? = null,
    val price: VehiclePrice? = null,
    val photos: List<VehiclePhoto>? = null
) {
    @JsonIgnore
    fun isFullVehicle() = vehicle != null && price != null && hasEnoughPhotos()

    fun toFullVehicle(): FullVehicle {
        if (!hasEnoughPhotos()) {
            throw IllegalArgumentException("Vehicle has not enough photos. $this")
        }

        return FullVehicle(
            id,
            vehicle ?: throw IllegalArgumentException("Vehicle is not fullfilled. $this"),
            price ?: throw IllegalArgumentException("Price is not fullfilled. $this"),
            photos ?: throw IllegalArgumentException("Photos is not fullfilled. $this")
        )
    }

    private fun hasEnoughPhotos() = (photos?.size ?: 0) >= 2
}