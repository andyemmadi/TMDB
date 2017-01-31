package com.example.ramu.tmdb.Model;

import java.util.List;

/**
 * Created by Ramu on 1/30/2017.
 */

public class ResponseMovieTitles {

    List<MovieTitles> Search;
    String totalResults;
    String Response;

    public ResponseMovieTitles(List<MovieTitles> search, String totalResults, String response) {
        this.Search = search;
        this.totalResults = totalResults;
        this.Response = response;
    }

    public List<MovieTitles> getSearch() {
        return Search;
    }

    public void setSearch(List<MovieTitles> search) {
        Search = search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }
}
