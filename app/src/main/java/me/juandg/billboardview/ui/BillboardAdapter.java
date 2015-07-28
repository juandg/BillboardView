package me.juandg.billboardview.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import me.juandg.billboardview.R;
import me.juandg.billboardview.models.Movie;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BillboardAdapter extends RecyclerView.Adapter<BillboardAdapter.ViewHolder> {
    private Context mContext;
    private List<Movie> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.thumbnail)
        ImageView thumbnail;
        @Bind(R.id.title)
        TextView title;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public BillboardAdapter(List<Movie> myDataset, Context context) {
        mDataset = myDataset;
        mContext = context;
    }

    @Override
    public BillboardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.billboard_layout, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = mDataset.get(position);
        if (movie != null) {
            Glide.with(mContext).load(movie.getPosters().getThumbnail()).fitCenter().into(holder.thumbnail);
            holder.title.setText(movie.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void addMovies(List<Movie> movies) {
        mDataset.addAll(movies);
        notifyDataSetChanged();
    }
}
