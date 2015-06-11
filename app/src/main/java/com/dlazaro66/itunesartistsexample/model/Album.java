package com.dlazaro66.itunesartistsexample.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by david on 10/6/15.
 * Pojo representing an album
 */
public class Album implements Serializable {
    String coverImageUrl;
    String albumName;
    Date releaseDate;

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
