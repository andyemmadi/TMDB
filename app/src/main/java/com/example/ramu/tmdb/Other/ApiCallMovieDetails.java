package com.example.ramu.tmdb.Other;

import android.util.Log;

import com.example.ramu.tmdb.Model.MovieDetails;
import com.example.ramu.tmdb.Network.NetworkManager;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ramu on 1/30/2017.
 */

public class ApiCallMovieDetails {

    MovieDetails t_movieDetails;

    public ApiCallMovieDetails(){

    }


    public void fetchMovieDetails(String id, String plot){

        NetworkManager mnetworkManager = new NetworkManager();

        final Call<MovieDetails> movieDetials = mnetworkManager.getmMovieServices().getMovieDetails(id,plot);

        movieDetials.enqueue(new Callback<MovieDetails>() {
            @Override
            public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {

                t_movieDetails = response.body();

                if(response.isSuccessful()){
                    Log.e("fetchMovies"," "+t_movieDetails.getTitle());
                    Log.e("fetchMovies"," "+t_movieDetails.getActors());
                }
                else {
                    Log.e("onRespnonse","Custome Error"+response.code());
                }

            }

            @Override
            public void onFailure(Call<MovieDetails> call, Throwable t) {
                if(t instanceof UnknownHostException){
                    Log.e("onFailure","No network"+t.getMessage());
                }else if(t instanceof SocketTimeoutException){
                    Log.e("onFailure","Time out"+t.getMessage());
                }
                else
                    Log.e("onFailure","error"+t.getMessage());
            }
        });
    }
    public MovieDetails getMovieDetails(){
        return this.t_movieDetails;
    }

}
