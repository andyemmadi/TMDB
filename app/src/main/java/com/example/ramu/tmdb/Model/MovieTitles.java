package com.example.ramu.tmdb.Model;

/**
 * Created by Ramu on 1/29/2017.
 */

public class MovieTitles {
//    {"Title":"Dil Chahta Hai",
//            "Year":"2001",
//            "imdbID":"tt0292490",
//            "Type":"movie",
//            "Poster":"https://images-na.ssl-images-amazon.com/images/M/MV5BOTIyODkwNzY2NF5BMl5BanBnXkFtZTgwMzE5NDUzNTE@._V1_SX300.jpg"},

    int id;
    String Title;
    String Year;
    String imdbID;
    String Type;
    String Poster;

    MovieTitles(){

    }

    public MovieTitles(int id, String title, String year, String imdbID, String type, String poster) {
        this.id = id;
        this.Title = title;
        this.Year = year;
        this.imdbID = imdbID;
        this.Type = type;
        this.Poster = poster;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }
}
