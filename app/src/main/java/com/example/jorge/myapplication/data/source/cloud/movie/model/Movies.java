package com.example.jorge.myapplication.data.source.cloud.movie.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Model for get API Movies with this field
 */

public class Movies implements Serializable {

        private int id;
        private String title;
        @SerializedName("poster_path")
        private String posterPath;
        @SerializedName("vote_average")
        private float voteAverage;
        @SerializedName("release_date")
        private String releaseDate;
        private String overview;
        private String original_language;


    public String getId() {
            return Integer.toString(id);
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String poster_path) {
        this.posterPath = poster_path;
    }

        public String getVoteAverage() {
            return toString().valueOf(voteAverage);
        }

        public void setVoteAverage(float vote_average) {
            this.voteAverage = vote_average;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String release_date) {
            this.releaseDate = release_date;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }
}
