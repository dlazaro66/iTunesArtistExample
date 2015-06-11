package com.dlazaro66.itunesartistsexample.artistDetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.dlazaro66.itunesartistsexample.R;
import com.dlazaro66.itunesartistsexample.common.BaseActivity;
import com.dlazaro66.itunesartistsexample.common.Callback;
import com.dlazaro66.itunesartistsexample.image.ImageLoader;
import com.dlazaro66.itunesartistsexample.model.Artist;
import com.dlazaro66.itunesartistsexample.widget.DividerItemDecorator;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by david on 11/6/15.
 */
public class ArtistDetailActivity extends BaseActivity implements ArtistDetailView {

    private static final String KEY_ARTIST = "com.dlazaro66.itunesartistsexample.artist";
    private ArtistDetailPresenter presenter;

    @InjectView(R.id.imgToolbar)
    ImageView toolbarImage;

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @InjectView(R.id.recycler_view)
    RecyclerView recyclerView;

    @InjectView(R.id.ctlLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;


    public static Intent getCallingIntent(Context context,Artist artist){

        if (artist == null)
            throw new IllegalArgumentException("Activity call should contain an Artist");

        Intent intent = new Intent(context,ArtistDetailActivity.class);
        intent.putExtra(KEY_ARTIST,artist);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_detail);
        ButterKnife.inject(this);
        if (getIntent().getExtras() == null)
            throw new IllegalArgumentException("Activity call should contain an Artist, did you start this activity calling 'getCallingIntent' static method?");
        Artist artist = (Artist) getIntent().getExtras().getSerializable(KEY_ARTIST);
        if (artist == null)
            throw new IllegalArgumentException("Artist param can't be null");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecorator(this, DividerItemDecorator.VERTICAL_LIST));

        presenter = new ArtistDetailPresenter();
        presenter.onViewReady(this);
        presenter.onArtistReceived(artist);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void renderArtist(Artist artist) {
        collapsingToolbarLayout.setTitle(artist.getArtistName());
        if (artist.getAlbums() != null){
            AlbumAdapter adapter = new AlbumAdapter(artist.getAlbums());
            recyclerView.setAdapter(adapter);
        }
        toolbarImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageLoader.loadWithPalette(this, artist.getLastReleasedAlbum().getCoverImageUrl(), toolbarImage, R.color.primary, new Callback<Palette>() {
            @Override
            public void onSuccess(Palette palette) {
                int toolBarColor = palette.getVibrantColor(R.color.primary);
                int statusbarColor = palette.getDarkVibrantColor(R.color.primary_dark);
                collapsingToolbarLayout.setContentScrimColor(toolBarColor);
                changeStatusBarColor(statusbarColor);
            }
            @Override
            public void onFailure(Throwable error) {

            }
        });
    }
}
