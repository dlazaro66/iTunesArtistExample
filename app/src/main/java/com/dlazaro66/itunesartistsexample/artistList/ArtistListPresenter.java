package com.dlazaro66.itunesartistsexample.artistList;

import android.util.Log;

import com.dlazaro66.itunesartistsexample.common.BasePresenter;
import com.dlazaro66.itunesartistsexample.common.Callback;
import com.dlazaro66.itunesartistsexample.data.ITunesRepository;
import com.dlazaro66.itunesartistsexample.data.ITunesRepositoryImpl;
import com.dlazaro66.itunesartistsexample.model.Artist;

import java.util.List;

/**
 * Created by david on 10/6/15.
 */
public class ArtistListPresenter extends BasePresenter<ArtistListView> {

    ITunesRepository repository = new ITunesRepositoryImpl();

    @Override
    public void onViewReady(ArtistListView view) {
        super.onViewReady(view);
        requestElements();
    }

    private void requestElements() {
        getView().showLoadingView();
        repository.getArtists(new Callback<List<Artist>>() {
            @Override
            public void onSuccess(List<Artist> result) {
                if (isViewAttached()) {
                    getView().hideLoadingView();
                    getView().renderResults(result);
                }
            }

            @Override
            public void onFailure(Throwable error) {
                if (isViewAttached()) {
                    getView().hideLoadingView();
                    getView().showErrorMessage();
                    Log.e("error", error.getMessage());
                }
            }
        });
    }

    @Override
    public void onDetachedView() {
        super.onDetachedView();
    }

    public void onRefreshPulled() {
        requestElements();
    }

    public void onRetryButtonPressed() {
        requestElements();
    }

    public void onArtistSelected(Artist artist) {
        if (isViewAttached())
            getView().openArtistDetailActivity(artist);
    }
}
