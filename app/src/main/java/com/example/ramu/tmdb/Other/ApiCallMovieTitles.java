package com.example.ramu.tmdb.Other;

import android.util.Log;

import com.example.ramu.tmdb.Model.MovieTitles;
import com.example.ramu.tmdb.Model.ResponseMovieTitles;
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

public class ApiCallMovieTitles {

    List<MovieTitles> t_movieTitles;

    public ApiCallMovieTitles(){

    }

    public List<MovieTitles> getMovieTitles(){
        return this.t_movieTitles;
    }


    public void fetchTitleFromNet(String keyword,String plot){

        NetworkManager mnetworkManager = new NetworkManager();

        final Call<ResponseMovieTitles> movietitles = mnetworkManager.getmMovieServices().getMovies(keyword,plot);

        movietitles.enqueue(new Callback<ResponseMovieTitles>() {
            @Override
            public void onResponse(Call<ResponseMovieTitles> call, Response<ResponseMovieTitles> response) {

                t_movieTitles = response.body().getSearch();

                if(response.isSuccessful()){
                    Log.e("onResponse"," "+t_movieTitles.get(0).getTitle());
                }
                else {
                    Log.e("onRespnonse","Custome Error"+response.code());
                }

            }

            @Override
            public void onFailure(Call<ResponseMovieTitles> call, Throwable t) {

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


}
