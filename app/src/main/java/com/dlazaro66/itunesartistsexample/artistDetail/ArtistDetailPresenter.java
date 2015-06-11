package com.dlazaro66.itunesartistsexample.artistDetail;

import com.dlazaro66.itunesartistsexample.common.BasePresenter;
import com.dlazaro66.itunesartistsexample.model.Artist;

/**
 * Created by david on 11/6/15.
 * @description Presenter for ArtistDetailView
 */
public class ArtistDetailPresenter extends BasePresenter<ArtistDetailView> {

    @Override
    public void onViewReady(ArtistDetailView view) {
        super.onViewReady(view);
    }

    @Override
    public void onDetachedView() {
        super.onDetachedView();
    }

    public void onArtistReceived(Artist artist) {
        getView().renderArtist(artist);
    }
}
