package me.juandg.billboardview.services;

import android.util.Log;

import java.util.List;

import me.juandg.billboardview.models.Movie;
import me.juandg.billboardview.models.Page;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public enum MovieProvider {
    INSTANCE;

    public static final int COLUMN_SIZE = 3;

    private static final String TAG = "MovieProvider";
    private static final String API_KEY = "9htuhtcb4ymusd73d4z6jxcj";
    private static final int PAGE_SIZE = COLUMN_SIZE * 9;
    private static final String API_URL = "http://api.rottentomatoes.com";

    private static int MAX_PAGES = 1;
    private static String searchTerm = "the";

    private MovieService mService;

    public interface UpdateCallback {
        void update(List<Movie> movies);
    }

    MovieProvider() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();

        mService = restAdapter.create(MovieService.class);
    }

    public void getMoviePage(final int pageNumber, final UpdateCallback callback) {
        mService.getMoviePage(API_KEY, searchTerm, PAGE_SIZE, pageNumber, new Callback<Page>() {
            @Override
            public void success(Page page, Response response) {
                if (pageNumber <= MAX_PAGES) {
                    if (pageNumber == 1) {
                        MAX_PAGES += (page.getTotal() / PAGE_SIZE);
                    }
                    callback.update(page.getMovies());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, error.getLocalizedMessage(), error);
            }
        });
    }
}
