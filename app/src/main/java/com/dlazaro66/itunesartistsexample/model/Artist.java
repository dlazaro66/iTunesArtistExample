package com.dlazaro66.itunesartistsexample.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 10/6/15.
 * Pojo representing an Artist
 */
public class Artist implements Serializable {

    String artistName;
    List<Album> albums;

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public Album getLastReleasedAlbum() {
        if (albums == null || albums.size() == 0)
            return null;

        Album lastReleasedAlbum = albums.get(0);
        for (Album album : albums) {
            if (album.getReleaseDate() != null && album.getReleaseDate() != null)
                if (album.getReleaseDate().after(lastReleasedAlbum.getReleaseDate()))
                    lastReleasedAlbum = album;
        }
        return lastReleasedAlbum;
    }

    public void addAlbum(Album album) {
        if (this.albums == null)
            this.albums = new ArrayList<>();
        this.albums.add(album);
    }
}
