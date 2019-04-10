package com.example.jorge.myapplication.detailMovies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.jorge.myapplication.R;
import com.example.jorge.myapplication.data.source.cloud.movie.model.Movies;
import com.squareup.picasso.Picasso;

import static com.example.jorge.myapplication.util.PathForApi.URL_IMAGE;
import static com.example.jorge.myapplication.util.PathForApi.URL_SIZE_W500;

public class DetailMoviesFragment extends Fragment implements DetailMoviesContract.View {

    private DetailMoviesContract.UserActionsListener mActionsListener;

    private static String mId;

    private ImageView mMovieImage;
    private TextView mTitle;
    private TextView mOverview;
    private TextView mReleseDate;
    private TextView mVoteAverage;


    private static Movies mDetailMovies;

    public DetailMoviesFragment() {
    }

    public static DetailMoviesFragment newInstance(Movies detailMovies) {
        mDetailMovies = detailMovies;
        return new DetailMoviesFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActionsListener = new DetailMoviesPresenter(this, getContext());
    }

    @Override
    public void onResume() {
        super.onResume();
        mActionsListener.loadingDetailMovies(mDetailMovies);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_detail_movies, container, false);

        mMovieImage = (ImageView) root.findViewById(R.id.iv_imageMovie_detail);
        mTitle = (TextView) root.findViewById(R.id.tv_Title_detail);
        mOverview = (TextView) root.findViewById(R.id.tv_overview_detail);
        mReleseDate = (TextView) root.findViewById(R.id.tv_release_date_detail);
        mVoteAverage = (TextView) root.findViewById(R.id.tv_vote_average_detail);




        return root;
    }

    @Override
    public void setLoading(boolean isActive) {

    }

    @Override
    public void showDetailMovies(Movies detailMoviesList) {

        mDetailMovies = detailMoviesList;


        mTitle.setText(mDetailMovies.getTitle());
        mOverview.setText(mDetailMovies.getOverview());
        mOverview.setText(mDetailMovies.getVoteAverage());
        mOverview.setText(mDetailMovies.getOriginal_language());
        mOverview.setText(mDetailMovies.getReleaseDate());

        Picasso.with(mMovieImage.getContext())
                .load(URL_IMAGE + URL_SIZE_W500 + mDetailMovies.getPosterPath())
                .fit()
                .placeholder(R.mipmap.ic_launcher)
                .into(mMovieImage);
    }

}


