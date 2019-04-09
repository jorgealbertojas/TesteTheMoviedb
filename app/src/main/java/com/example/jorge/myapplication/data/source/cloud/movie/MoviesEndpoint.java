package com.example.jorge.myapplication.data.source.cloud.movie;

import com.example.jorge.myapplication.data.source.cloud.movie.model.Movies;
import retrofit2.Call;
import retrofit2.http.GET;

import static com.example.jorge.myapplication.util.PathForApi.API_KEY;
import static com.example.jorge.myapplication.util.PathForApi.MIDLLE_POPULAR;
import static com.example.jorge.myapplication.util.PathForApi.MIDLLE_TOP_RATED;

public interface MoviesEndpoint {

    /**
     * Get order Popular API Retrofit
     */
    @GET(MIDLLE_POPULAR + API_KEY)
    Call<ListMovies<Movies>> getMoviesPOPULAR();

    /**
     * Get order Top Rated API Retrofit
     */
    @GET(MIDLLE_TOP_RATED + API_KEY)
    Call<ListMovies<Movies>> getMoviesTOP_RATED();
}
