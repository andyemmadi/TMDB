package com.example.ramu.tmdb.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ramu.tmdb.Model.MovieDetails;
import com.example.ramu.tmdb.Network.NetworkManager;
import com.example.ramu.tmdb.R;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ramu on 1/30/2017.
 */

public class MovieDetailFragment extends Fragment {


    TextView title_tv, generic_tv, rating_tv, awards_tv, metascore_tv, cast_tv, naration_tv;
    ImageView poster_iv;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.search);
        item.setVisible(false);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.movie_detail,container,false);

        Bundle bundle = getArguments();
        String id = bundle.getString("id");
        fetchMovie(id);

        poster_iv = (ImageView) view.findViewById(R.id.detail_poster);
        title_tv = (TextView) view.findViewById(R.id.detail_title);
        generic_tv = (TextView) view.findViewById(R.id.detail_generic);
        rating_tv = (TextView) view.findViewById(R.id.detail_rating);
        awards_tv = (TextView) view.findViewById(R.id.detail_awards);
        metascore_tv = (TextView) view.findViewById(R.id.detail_metascore);
        cast_tv = (TextView) view.findViewById(R.id.detail_cast);
        naration_tv = (TextView) view.findViewById(R.id.detail_narration);

        return view;
    }




    public void fetchMovie(String id) {

        NetworkManager mnetworkManager = new NetworkManager();

        final Call<MovieDetails> movieDetials = mnetworkManager.getmMovieServices().getMovieDetails(id,"full");

        movieDetials.enqueue(new Callback<MovieDetails>() {
            @Override
            public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {

                MovieDetails movieDetails = response.body();

                if(response.isSuccessful()){
                    // mMoviedetails = response.body();
                    Log.e("fetchMovies"," "+movieDetails.getTitle());
                    Log.e("fetchMovies"," "+movieDetails.getActors());
                    bindDataToView(response.body());
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



    public void bindDataToView(MovieDetails movieDetails){

        Glide.with(getActivity())
                .load(movieDetails.getPoster())
                .placeholder(R.mipmap.ic_launcher)
                .into(poster_iv);
        title_tv.setText(movieDetails.getTitle()+" ("+movieDetails.getYear()+")");
        generic_tv.setText(movieDetails.getGenre());
        rating_tv.setText(" Rating "+movieDetails.getRated());
        awards_tv.setText(" Awards "+movieDetails.getAwards());
        metascore_tv.setText(" Metascore "+movieDetails.getMetascore());
        cast_tv.setText(" Actors "+movieDetails.getActors());
        naration_tv.setText(" Narration "+movieDetails.getPlot());


    }
}
