package com.dlazaro66.itunesartistsexample;

import com.dlazaro66.itunesartistsexample.model.Artist;

import org.junit.Test;

import static org.junit.Assert.assertNull;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ArtistTest {

    @Test
    public void testNewArtistHaveNotAlbums(){
        Artist artist = new Artist();
        assertNull(artist.getAlbums());
    }
}