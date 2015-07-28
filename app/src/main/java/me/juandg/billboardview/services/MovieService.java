package me.juandg.billboardview.services;

import me.juandg.billboardview.models.Page;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface MovieService {

    @GET("/api/public/v1.0/movies.json")
    void getMoviePage(@Query("apikey") String apikey, @Query("q") String searchTerm,
                      @Query("page_limit") int pageLimit, @Query("page") int page, Callback<Page> callback);
}
