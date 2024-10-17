package com.example.flightsearch.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "airport")
data class Airport(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("iata_code")
    val code: String = "",
    @ColumnInfo("name")
    val name: String = "",
    @ColumnInfo("passengers")
    val passengers: Int = 0
)
