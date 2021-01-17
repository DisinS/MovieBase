package com.example.moviebase.DataModels.TVDetailFolder

import com.example.moviebase.DataModels.MovieDetailFolder.Genres

data class TV (
    val backdrop_path : String,
    val created_by : List<Created_by>,
    val episode_run_time : List<Int>,
    val first_air_date : String,
    val genres : List<Genres>,
    val homepage : String,
    val id : Int,
    val in_production : Boolean,
    val languages : List<String>,
    val last_air_date : String,
    val last_episode_to_air : Last_episode_to_air,
    val name : String,
    val next_episode_to_air : Next_episode_to_air,
    val networks : List<Networks>,
    val number_of_episodes : Int,
    val number_of_seasons : Int,
    val origin_country : List<String>,
    val original_language : String,
    val original_name : String,
    val overview : String,
    val popularity : Double,
    val poster_path : String,
    val production_companies : List<Production_companies>,
    val production_countries : List<Production_countries>,
    val seasons : List<Seasons>,
    val spoken_languages : List<Spoken_languages>,
    val status : String,
    val tagline : String,
    val type : String,
    val vote_average : Double,
    val vote_count : Int
)