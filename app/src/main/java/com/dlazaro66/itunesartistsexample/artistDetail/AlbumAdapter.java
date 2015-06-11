package com.dlazaro66.itunesartistsexample.artistDetail;

/**
 * Created by david on 11/6/15.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dlazaro66.itunesartistsexample.R;
import com.dlazaro66.itunesartistsexample.image.ImageLoader;
import com.dlazaro66.itunesartistsexample.model.Album;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by david on 10/6/15.
 * @description Adapter which render Album info
 */
public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> implements View.OnClickListener {


    private List<Album> albums;

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {

        void onItemClick(View v, Album album);
    }

    public AlbumAdapter(List<Album> albums) {
        this.albums = albums;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public AlbumAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_single_album, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final AlbumAdapter.ViewHolder holder, int position) {

        Album item = albums.get(position);

        if (item.getAlbumName() != null)
            holder.albumNameTextView.setText(item.getAlbumName());

        if (item.getCoverImageUrl() != null)
            ImageLoader.load(holder.coverImageView.getContext(), item.getCoverImageUrl(),holder.coverImageView);

        holder.view.setTag(item);
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    @Override
    public void onClick(final View v) {

        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(v, (Album) v.getTag());
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        View view;

        @InjectView(R.id.album_cover_imageview)
        ImageView coverImageView;

        @InjectView(R.id.album_name_textview)
        TextView albumNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.inject(this, itemView);
        }
    }
}



