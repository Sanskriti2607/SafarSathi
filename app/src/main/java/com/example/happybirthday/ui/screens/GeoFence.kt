package com.example.happybirthday.model

data class GeofenceData(
    val stationName: String,
    val latitude: Double,
    val longitude: Double,
    val radius: Float,
    val geofenceName: String,
    val alertType: String


)
