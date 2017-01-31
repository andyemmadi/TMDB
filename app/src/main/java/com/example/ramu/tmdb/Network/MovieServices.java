package com.example.ramu.tmdb.Network;

/**
 * Created by Ramu on 1/29/2017.
 */

import com.example.ramu.tmdb.Model.MovieDetails;
import com.example.ramu.tmdb.Model.MovieTitles;
import com.example.ramu.tmdb.Model.ResponseMovieTitles;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *
 public interface NasaService {
@GET("planetary/apod?api_key=DEMO_KEY")
Call<OneDayData> getTodaysPictureDate();
}
 */

public interface MovieServices {
    @GET("/")
    Call<ResponseMovieTitles> getMovies(
            @Query("s") String page,
            @Query("plot") String plot);

    @GET("/")
    Call<MovieDetails> getMovieDetails(
            @Query("i") String id,
            @Query("plot") String plot);
}
