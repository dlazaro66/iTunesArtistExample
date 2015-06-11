package com.dlazaro66.itunesartistsexample.artistList;

import android.graphics.drawable.Drawable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dlazaro66.itunesartistsexample.R;
import com.dlazaro66.itunesartistsexample.common.Callback;
import com.dlazaro66.itunesartistsexample.image.ImageLoader;
import com.dlazaro66.itunesartistsexample.model.Album;
import com.dlazaro66.itunesartistsexample.model.Artist;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by david on 10/6/15.
 * @description Adapter which render Artists info
 */
public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ViewHolder> implements View.OnClickListener {


    private List<Artist> artists;

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {

        void onItemClick(View v, Artist artist);
    }

    public ArtistAdapter(List<Artist> artists) {
        this.artists = artists;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public ArtistAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_single_artist, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ArtistAdapter.ViewHolder holder, int position) {

        Artist item = artists.get(position);

        if (item.getArtistName() != null)
            holder.artistNameTextView.setText(item.getArtistName());

        Album lastReleasedAlbum = item.getLastReleasedAlbum();

        if (lastReleasedAlbum != null && lastReleasedAlbum.getCoverImageUrl() != null) {
            ImageLoader.loadWithPalette(holder.coverImageView.getContext(),
                    lastReleasedAlbum.getCoverImageUrl(),
                    holder.coverImageView,
                    R.color.primary_dark,
                    new Callback<Palette>() {
                        @Override
                        public void onSuccess(Palette palette) {
                            holder.textLayout.setBackgroundColor(palette.getDarkVibrantColor(R.color.accent));
                            Drawable background = holder.textLayout.getBackground();
                            background.setAlpha(230);
                        }

                        @Override
                        public void onFailure(Throwable error) {

                        }
                    });
        }
        holder.view.setTag(item);
        holder.view.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    @Override
    public void onClick(final View v) {

        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(v, (Artist) v.getTag());
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        View view;

        @InjectView(R.id.text_layout)
        RelativeLayout textLayout;

        @InjectView(R.id.cover_imageview)
        ImageView coverImageView;

        @InjectView(R.id.artist_name_textview)
        TextView artistNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.inject(this, itemView);
        }
    }
}


