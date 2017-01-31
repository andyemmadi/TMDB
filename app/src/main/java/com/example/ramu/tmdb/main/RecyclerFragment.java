package com.example.ramu.tmdb.main;


import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ramu.tmdb.Model.MovieTitles;
import com.example.ramu.tmdb.Model.ResponseMovieTitles;
import com.example.ramu.tmdb.Network.NetworkManager;
import com.example.ramu.tmdb.R;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ramu on 1/30/2017.
 */

public class RecyclerFragment extends Fragment {


    RecyclerView mrecyclerview;

    FragmentActivity activity;
    RecyclerAdapter recyclerAdapter;
    LinearLayoutManager linearLayoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview,container,false);

        mrecyclerview = (RecyclerView) view.findViewById(R.id.frag_recycler_view);

        recyclerAdapter = new RecyclerAdapter(getActivity());

        activity = getActivity();
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mrecyclerview.setLayoutManager(layoutManager);

        //mrecyclerview.setLayoutManager(linearLayoutManager);
        mrecyclerview.setAdapter(recyclerAdapter);
          recyclerAdapter.notifyDataSetChanged();

            Bundle bundle = getArguments();
            String term = bundle.getString("query");

            fetchMovieTiles(term,"full");

//
//        mrecyclerview.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Toast.makeText(MainActivity.this, "Card at " + position + " is clicked", Toast.LENGTH_SHORT).show();
//            }
//        }));
//



        return view;
    }



    public void fetchMovieTiles(String keyword, String plot) {

        NetworkManager mnetworkManager = new NetworkManager();

        final Call<ResponseMovieTitles> movietitles = mnetworkManager.getmMovieServices().getMovies(keyword,plot);

        movietitles.enqueue(new Callback<ResponseMovieTitles>() {
            @Override
            public void onResponse(Call<ResponseMovieTitles> call, Response<ResponseMovieTitles> response) {

                List<MovieTitles> t_movieTitles = response.body().getSearch();

                if(response.isSuccessful()){

                    // mMovieTitles = response.body().getSearch();
                    //Log.e("onResponse"," "+t_movieTitles.get(0).getTitle());

                    recyclerAdapter.changeMovieList(response.body().getSearch());

                    //   adapter.notifyDataSetChanged();
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
