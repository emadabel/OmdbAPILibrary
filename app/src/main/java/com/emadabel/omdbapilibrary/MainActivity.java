package com.emadabel.omdbapilibrary;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.emadabel.openmoviesdbapilibrary.MovieDb;
import com.emadabel.openmoviesdbapilibrary.OmdbApi;
import com.emadabel.openmoviesdbapilibrary.OmdbMovies;
import com.emadabel.openmoviesdbapilibrary.SearchResults;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private OmdbApi omdbApi;
    String numberOfResults;
    List<OmdbMovies> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        omdbApi = new OmdbApi("OMDB API KEY");
        new FetchData().execute("SOME TEXT MOVIE TO SEARCH ABOUT");
    }

    private class FetchData extends AsyncTask<String, Void, SearchResults> {
        @Override
        protected SearchResults doInBackground(String... strings) {
            /* To get specific movie data */
            //MovieDb movieData = omdbApi.getMovieData("IMDB ID");
            //String plot = movieData.getPlot();

            return omdbApi.getMovies(strings[0]);
        }

        @Override
        protected void onPostExecute(SearchResults searchResults) {
            if (!searchResults.isResponse()) return;

            numberOfResults = searchResults.getTotalResults(); //How many movies returned by the search
            movies = searchResults.getMovies(); //List includes 10 movies of results (Page 1). This version of the Api currently getting 1st page only.
            /**
             * Each object of the list contains movies data you can retrieve with one of thenext methods
             */
            /*
                movies.get(0).getImdbId();
                movies.get(0).getMovieTitle();
                movies.get(0).getPoster();
                movies.get(0).getReleaseYear();
                movies.get(0).getType();
            */
        }
    }
}
