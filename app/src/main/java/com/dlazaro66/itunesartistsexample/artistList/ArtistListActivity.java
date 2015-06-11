package com.dlazaro66.itunesartistsexample.artistList;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;

import com.dlazaro66.itunesartistsexample.R;
import com.dlazaro66.itunesartistsexample.artistDetail.ArtistDetailActivity;
import com.dlazaro66.itunesartistsexample.common.BaseActivity;
import com.dlazaro66.itunesartistsexample.model.Artist;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @description Activity which show a list of artists.
 */
public class ArtistListActivity extends BaseActivity implements ArtistListView, SwipeRefreshLayout.OnRefreshListener {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @InjectView(R.id.recycler_view)
    RecyclerView recyclerView;

    @InjectView(R.id.activity_main_swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    ArtistListPresenter presenter;
    private View latestPressedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_list);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.itunes_bands));
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.primary),
                getResources().getColor(R.color.accent));
        swipeRefreshLayout.setOnRefreshListener(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, getResources().getInteger(R.integer.artist_list_number_of_rows)));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        enableWorkaroundForSwipeRefreshLayoutAndReclyclerView(swipeRefreshLayout);

        presenter = new ArtistListPresenter();
        presenter.onViewReady(this);
    }



    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        presenter.onDetachedView();
    }

    @Override
    public void showLoadingView() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoadingView() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void renderResults(List<Artist> artistList) {
        ArtistAdapter adapter = new ArtistAdapter(artistList);
        adapter.setOnItemClickListener(new ArtistAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, Artist artist) {
                latestPressedView= v;
                presenter.onArtistSelected(artist);
            }
        });
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void showErrorMessage() {
        Snackbar.make(findViewById(android.R.id.content), R.string.error, Snackbar.LENGTH_LONG)
                .setAction(R.string.retry, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.onRetryButtonPressed();
                    }
                })
                .show();
    }

    @Override
    public void openArtistDetailActivity(Artist artist) {
        Intent intent = ArtistDetailActivity.getCallingIntent(this, artist);

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this, latestPressedView, getString(R.string.artist_cover_transition_id) );

        ActivityCompat.startActivity(this, intent,
                options.toBundle());
    }

    @Override
    public void onRefresh() {
        presenter.onRefreshPulled();
    }

    // That's a workaround for a reported issue
    // @see https://code.google.com/p/android/issues/detail?id=77712
    // TODO try to fix ASAP
    private void enableWorkaroundForSwipeRefreshLayoutAndReclyclerView(SwipeRefreshLayout swipeRefreshLayout) {
        swipeRefreshLayout.setProgressViewOffset(false, 0,
                (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        24,
                        getResources().getDisplayMetrics()));
    }
}
