package com.example.moviebase.API

import com.example.moviebase.DataModels.MovieDetailFolder.MovieDetail
import com.example.moviebase.DataModels.SearchModelFolder.SearchMovie
import com.example.moviebase.DataModels.SearchModelFolder.SearchPeople
import com.example.moviebase.DataModels.SearchModelFolder.SearchTv
import com.example.moviebase.DataModels.TVDetailFolder.TV
import com.example.moviebase.DataModels.TrendingModelFolder.TrendingModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val API: String = "?api_key=fbfd2d53b7504d595ee9c450e52d4026"
//Zostawmy angielski bo wszystko działa, w polskim pokazuje z połowe rzeczy
const val LANGUAGE: String = "en-US"

interface MovieAPI {
    //API: fbfd2d53b7504d595ee9c450e52d4026
    //Zapytania: https://developers.themoviedb.org/3/getting-started/introduction
    //JSON na klasy w kotlin: https://www.json2kotlin.com/
    //Przetwarzanie obrazów: https://developers.themoviedb.org/3/getting-started/images
    /*
    Trendujące filmy/seriale/osoby na dzień dzisiejszy lub tydzień
    https://developers.themoviedb.org/3/trending/get-trending
    mediaType => all/movie/tv/person
    timeWindow => day/week
    */
    @GET("trending/{mediaType}/{timeWindow}${API}")
    suspend fun getTrending(
        @Path("mediaType") mediaType: String,
        @Path("timeWindow") timeWindow: String
    ): Response<TrendingModel>

    /*Informacje o filmie
    https://developers.themoviedb.org/3/movies/get-movie-details
    movie_id => id filmu
    language => język odpowiedzi, załóżmy że bazowym będzie pl-PL
     */
    @GET("movie/{movieID}${API}&language=${LANGUAGE}")
    suspend fun getMovieDetails(
        @Path("movieID") movieID: Int
    ): Response<MovieDetail>

    //Informacja o serii TV
    @GET("tv/{id}${API}&language=${LANGUAGE}")
    suspend fun getTVDetails(
        @Path("id") id:Int
    ) : Response<TV>

    /*Wyszukiwanie filmów
    query => fraza do wyszukania
    */
    @GET("search/movie${API}&language=${LANGUAGE}")
    suspend fun searchMovies(
        @Query("query") query: String
    ): Response<SearchMovie>
    /*Wyszukiwanie osób
    query => fraza do wyszukania
    */
    @GET("search/person${API}&language=${LANGUAGE}")
    suspend fun searchPeople(
        @Query("query") query: String
    ): Response<SearchPeople>
    /*Wyszukiwanie seriali
    query => fraza do wyszukania
    */
    @GET("search/tv${API}&language=${LANGUAGE}")
    suspend fun searchTv(
        @Query("query") query: String
    ): Response<SearchTv>

    companion object {
        operator fun invoke(): MovieAPI {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.themoviedb.org/3/")
                .build()
                .create(MovieAPI::class.java)
        }
    }
}