package com.example.ramu.tmdb.Model;

/**
 * Created by Ramu on 1/30/2017.
 */

public class MovieDetails {

    /*

            {"Title":"Dil Chahta Hai",
            "Year":"2001",
            "Rated":"NOT RATED",
            "Released":"24 Jul 2001",
            "Runtime":"183 min",
            "Genre":"Comedy, Drama, Romance",
            "Director":"Farhan Akhtar",
            "Writer":"Kassim Jagmagia (story co-developed by), Farhan Akhtar (story), Farhan Akhtar (screenplay), Farhan Akhtar (dialogue)",
            "Actors":"Aamir Khan, Saif Ali Khan, Akshaye Khanna, Preity Zinta",
            "Plot":"Three young men Akash, Sameer, and Siddharth are close friends, but their tastes and characters are completely incompatible. So when Siddharth falls in love with a much older woman, Tara, a woman who has been unsuccessful in keeping her marriage intact as well as alcohol-dependent, widens the rift between the trio, forcing them to part company. Years later, the trio will be re-united, they will be much mature and understanding, but will they still accept Siddharth love for Tara, especially when they themselves have fallen in love with women around their respective ages?",
            "Language":"Hindi, English, Urdu",
            "Country":"India",
            "Awards":"21 wins & 36 nominations.",
            "Poster":"https://images-na.ssl-images-amazon.com/images/M/MV5BOTIyODkwNzY2NF5BMl5BanBnXkFtZTgwMzE5NDUzNTE@._V1_SX300.jpg",
            "Metascore":"N/A",
            "imdbRating":"8.2",
            "imdbVotes":"49,725",
            "imdbID":"tt0292490",
            "Type":"movie",
            "Response":"True"}

      */

    String Title;
    String Year;
    String Rated;
    String Released;
    String Runtime;
    String Genre;
    String Director;
    String Writer;
    String Actors;
    String Plot;
    String Language;
    String Country;
    String Awards;
    String Poster;
    String Metascore;
    String imdbRating;
    String imdbVotes;
    String imdbID;
    String Type;
    String Response;

    public MovieDetails(){

    }

    public MovieDetails(String title, String year, String rated, String released, String runtime, String genre, String director, String writer, String actors, String plot, String language, String country, String awards, String poster, String metascore, String imdbRating, String imdbVotes, String imdbID, String type, String response) {
        this.Title = title;
        this.Year = year;
        this.Rated = rated;
        this.Released = released;
        this.Runtime = runtime;
        this.Genre = genre;
        this.Director = director;
        this.Writer = writer;
        this.Actors = actors;
        this.Plot = plot;
        this.Language = language;
        this.Country = country;
        this.Awards = awards;
        this.Poster = poster;
        this.Metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbID = imdbID;
        this.Type = type;
        this.Response = response;
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

    public String getRated() {
        return Rated;
    }

    public void setRated(String rated) {
        Rated = rated;
    }

    public String getReleased() {
        return Released;
    }

    public void setReleased(String released) {
        Released = released;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getAwards() {
        return Awards;
    }

    public void setAwards(String awards) {
        Awards = awards;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getMetascore() {
        return Metascore;
    }

    public void setMetascore(String metascore) {
        Metascore = metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
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

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }
}
