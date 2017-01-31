package com.example.ramu.tmdb.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.widget.SearchView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ramu.tmdb.Model.MovieDetails;
import com.example.ramu.tmdb.Model.MovieTitles;
import com.example.ramu.tmdb.Model.ResponseMovieTitles;
import com.example.ramu.tmdb.Network.NetworkManager;
import com.example.ramu.tmdb.Other.ApiCallMovieDetails;
import com.example.ramu.tmdb.Other.ApiCallMovieTitles;
import com.example.ramu.tmdb.R;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.MainActivityCommunication{

    NetworkManager mnetworkManager;
  //  SearchView searchView;
    SearchView searchView;
   //  RecyclerView mrecyclerview;
   // RecyclerAdapter adapter;

  //  RecyclerFragment recyclerFragment=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mnetworkManager = new NetworkManager();

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.search);


        searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                  startRecyclerFragment(query);
                   return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }

        });

        //searchView.onActionViewCollapsed();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.search)
        {

            MenuItemCompat.setOnActionExpandListener(item, new MenuItemCompat.OnActionExpandListener() {
                @Override
                public boolean onMenuItemActionExpand(MenuItem item) {
                    return true;
                }

                @Override
                public boolean onMenuItemActionCollapse(MenuItem item) {
                    Log.e("searchview","collapsed");

                    return true;
                }
            });

        }
        return true;
    }

    public void startRecyclerFragment(String searchTerm){

        RecyclerFragment recyclerfragment = (RecyclerFragment) getSupportFragmentManager().findFragmentByTag("recycler_fragment");

        if(recyclerfragment == null){
            recyclerfragment = new RecyclerFragment();

            Bundle bundle = new Bundle();
            bundle.putString("query",searchTerm);
            recyclerfragment.setArguments(bundle);

             FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
             trans.add(R.id.activity_main,recyclerfragment,"recycler_fragment");
             trans.addToBackStack("recycler_fragment");
             Log.e("recyclerfragment","created");
             trans.commit();

        }else
        {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
           // transaction.attach(recyclerfragment);
            recyclerfragment.fetchMovieTiles(searchTerm,"full");
            Log.e("recyclerfragment","reused");
            //transaction.commit();
            // Toast.makeText(getAct,"re--adding the fragment B",Toast.LENGTH_LONG).show();
        }

/*
        RecyclerFragment fragment = new RecyclerFragment();
d        Bundle bundle = new Bundle();
        bundle.putString("query",searchTerm);
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.activity_main,fragment,"fragment");*/
    }

    @Override
    public void startMovieDetailFragment(String id) {
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        MovieDetailFragment detailFragment = (MovieDetailFragment) getSupportFragmentManager().findFragmentByTag("detail_fragment");
        if(detailFragment == null){

            Log.e("detailfragment","created");
            detailFragment = new MovieDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id",id);
            detailFragment.setArguments(bundle);

            trans.replace(R.id.activity_main,detailFragment,"detail_fragment");
            trans.addToBackStack("detail_fragment");
            trans.commit();

        }
        else{
            Log.e("detailfragment","reused");
            trans.replace(R.id.activity_main,detailFragment,"detail_fragment");
            detailFragment.fetchMovie(id);
        }
    }

    @Override
    public void onBackPressed() {
     //   super.onBackPressed();
          if (getFragmentManager().getBackStackEntryCount() > 0 ){
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
