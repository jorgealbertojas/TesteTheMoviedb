package com.example.jorge.myapplication.data.source.cloud.movie;

import com.example.jorge.myapplication.data.source.cloud.movie.model.Movies;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MoviesServiceImpl implements MoviesServiceApi {

    MoviesEndpoint mRetrofit;
    private static int page = 1;

    public MoviesServiceImpl(){
        mRetrofit = MoviesClient.getMovies().create(MoviesEndpoint.class);
    }

    @Override
    public void getMovies(final MoviesServiceCallback<ListMovies<Movies>> callback) {
        Call<ListMovies<Movies>> callMovies = mRetrofit.getMoviesPOPULAR(Integer.toString(page++));
        callMovies.enqueue(new Callback<ListMovies<Movies>>() {
            @Override
            public void onResponse(Call<ListMovies<Movies>> call, Response<ListMovies<Movies>> response) {
                if(response.code()==200){
                    ListMovies<Movies> resultSearch = response.body();
                    callback.onLoaded(resultSearch);
                }
            }

            @Override
            public void onFailure(Call<ListMovies<Movies>> call, Throwable t) {

            }
        });
    }
}
