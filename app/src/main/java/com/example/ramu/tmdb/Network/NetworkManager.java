package com.example.ramu.tmdb.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ramu on 1/29/2017.
 */

public class NetworkManager {


    public static final String BaseURL = "http://www.omdbapi.com";
    private Retrofit mretrofit;
    private MovieServices mMovieServices;
    public NetworkManager(){
        mretrofit = new Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mMovieServices = mretrofit.create(MovieServices.class);
    }

    public MovieServices getmMovieServices(){
        return this.mMovieServices;
    }

}
