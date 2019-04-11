package com.example.jorge.myapplication.data.source.cloud.movie;

import com.example.jorge.myapplication.data.source.cloud.movie.model.Movies;

import java.util.List;

public interface MoviesServiceApi {
    /**
     * Interface for signature Cars Service Callback
     * @param <T>
     */
    interface MoviesServiceCallback<T> {

        void onLoaded(ListMovies<Movies> carsList);

    }

    void getMovies(MoviesServiceCallback<ListMovies<Movies>> callback, Boolean popular);

}

