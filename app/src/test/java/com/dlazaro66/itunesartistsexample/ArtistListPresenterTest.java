package com.dlazaro66.itunesartistsexample;

import com.dlazaro66.itunesartistsexample.artistList.ArtistListPresenter;
import com.dlazaro66.itunesartistsexample.artistList.ArtistListView;
import com.dlazaro66.itunesartistsexample.model.Artist;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by david on 11/6/15.
 */
public class ArtistListPresenterTest {

    @Test
    public void testOnArtistSelectedOpenDetailActivity() {
        ArtistListPresenter presenter = new ArtistListPresenter();
        ArtistListView mockedView = mock(ArtistListView.class);
        Artist mockedArtist = mock(Artist.class);
        presenter.onArtistSelected(mockedArtist);
        verify(mockedView).openArtistDetailActivity(mockedArtist);
    }
}
