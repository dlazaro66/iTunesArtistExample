package com.dlazaro66.itunesartistsexample.artistList;

import com.dlazaro66.itunesartistsexample.model.Artist;

import java.util.List;

/**
 * Contract for the view which will render the list of Artists
 * Created by david on 10/6/15.
 */
public interface ArtistListView {
    void showLoadingView();
    void hideLoadingView();
    void renderResults(List<Artist> result);
    void showErrorMessage();
    void openArtistDetailActivity(Artist artist);
}
