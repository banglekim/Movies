package com.bangle.movie.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Movies {
    @JsonProperty("page")
    private String page;
    @JsonProperty("per_page")
    private Integer per_page;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("total_pages")
    private Integer totalPages;
    @JsonProperty("data")
    private List <MovieEntry> movies;

    public String getPage() {
        return this.page;
    }

    public void setPage ( String page ) {
        this.page = page;
    }

    public Integer getPer_page ( ) {
        return per_page;
    }

    public void setPer_page ( Integer per_page ) {
        this.per_page = per_page;
    }

    public Integer getTotal ( ) {
        return total;
    }

    public void setTotal ( Integer total ) {
        this.total = total;
    }

    public Integer getTotalPages ( ) {
        return totalPages;
    }

    public void setTotalPages ( Integer totalPages ) {
        this.totalPages = totalPages;
    }

    public List < MovieEntry > getMovies ( ) {
        return movies;
    }

    public void setMovies ( List < MovieEntry > movies ) {
        this.movies = movies;
    }
}
