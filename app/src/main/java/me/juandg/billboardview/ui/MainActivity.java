package me.juandg.billboardview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;


import me.juandg.billboardview.R;
import me.juandg.billboardview.models.Movie;
import me.juandg.billboardview.services.MovieProvider;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private boolean loading = true;
    private int visibleThreshold = 12;
    int firstVisibleItem, visibleItemCount, totalItemCount;

    private int pageNumber;

    @Bind(R.id.my_recycler_view)
    RecyclerView mRecyclerView;

    private BillboardAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final GridLayoutManager layoutManager = new GridLayoutManager(this, MovieProvider.COLUMN_SIZE);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new BillboardAdapter(new ArrayList<Movie>(), this);
        mRecyclerView.setAdapter(mAdapter);

        // Load first page of movies
        pageNumber = 1;
        loadMoviePage(pageNumber);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                visibleItemCount = recyclerView.getChildCount();
                totalItemCount = layoutManager.getItemCount();
                firstVisibleItem = layoutManager.findFirstVisibleItemPosition();

                if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
                    pageNumber++;
                    loading = true;
                    loadMoviePage(pageNumber);
                }
            }
        });
    }

    private void loadMoviePage(int pageNumber) {
        MovieProvider.INSTANCE.getMoviePage(pageNumber, new MovieProvider.UpdateCallback() {
            @Override
            public void update(List<Movie> movies) {
                mAdapter.addMovies(movies);
                loading = false;
            }
        });
    }
}
