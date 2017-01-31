package com.example.ramu.tmdb.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ramu.tmdb.Model.MovieTitles;
import com.example.ramu.tmdb.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramu on 1/30/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MovieTemplate> {


    Context mcontext;
    List<MovieTitles> movieTitles = new ArrayList<>();
    MainActivityCommunication activityCommunication;
    RecyclerAdapter(Context context){
        this.mcontext = context;
        activityCommunication = (MainActivityCommunication) context;
    }




    @Override
    public MovieTemplate onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.movie_item,parent,false);

        MovieTemplate movieTemplate = new MovieTemplate(view);
        return movieTemplate;

    }

    @Override
    public void onBindViewHolder(MovieTemplate holder, int position) {
            MovieTitles movie = movieTitles.get(position);
            holder.movieTitle.setText(movie.getTitle());
            holder.mType.setText(movie.getType());
            holder.movieYear.setText(movie.getYear());
            Glide.with(mcontext)
                    .load(movie.getPoster())
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return movieTitles.size();
    }


    public class MovieTemplate extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView movieTitle;
        TextView movieYear;
        TextView mType;
        View t_itemview;

        public MovieTemplate(View itemView) {
            super(itemView);
            t_itemview = itemView;
            imageView = (ImageView) itemView.findViewById(R.id.iv_movie_cover);
            movieTitle = (TextView) itemView.findViewById(R.id.tv_movie_name);
            movieYear = (TextView) itemView.findViewById(R.id.tv_movie_year);
            mType = (TextView) itemView.findViewById(R.id.tv_type);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = movieTitles.get(getAdapterPosition()).getImdbID();
                    activityCommunication.startMovieDetailFragment(id);

                }
            });


        }
    }
    public interface MainActivityCommunication{
        public void startMovieDetailFragment(String id);
    }


    public void addMovie(MovieTitles movieTitle){
        movieTitles.add(movieTitle);
    }
    public void changeMovieList(List<MovieTitles> movieTitlesList){


        for(int i=0;i<movieTitles.size();i++)
            movieTitles.remove(i);

        if(movieTitlesList != null)
        {
            movieTitles = movieTitlesList;
            notifyItemRangeChanged(0,movieTitles.size());
        }
        notifyDataSetChanged();

    }
}
