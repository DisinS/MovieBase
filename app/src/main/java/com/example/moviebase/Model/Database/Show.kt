package com.example.moviebase.Model.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "show_table")
data class Show(
    @PrimaryKey(autoGenerate = true)
    val ID: Int,
    val itemID: Int,
    val type: String,
    val posterPath: String,
    val backgroundPath: String,
    val title: String,
    val tagline: String,
    val releaseDate: String,
    val movieType: String,
    val movieDescription: String,
    val favourite: Boolean,
    val toWatch: Boolean
)