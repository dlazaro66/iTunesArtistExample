package com.dlazaro66.itunesartistsexample.data;

import android.util.Log;

import com.dlazaro66.itunesartistsexample.model.Album;
import com.dlazaro66.itunesartistsexample.model.Artist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 10/6/15.
 */
public class ApiDomainToModelDomainMapper {

    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public static List<Artist> map(List<ITunesWebServiceArtistResponse> apiResponse) {
        List<Artist> artistList = new ArrayList<>();

        if (apiResponse == null)
            return null;

        if (apiResponse.isEmpty())
            return artistList;

        for (ITunesWebServiceArtistResponse webServiceArtistResponse : apiResponse) {
            artistList.add(map(webServiceArtistResponse));
        }
        return artistList;
    }

    private static Artist map(ITunesWebServiceArtistResponse webServiceArtistResponse) {
        if (webServiceArtistResponse == null)
            return null;

        Artist artist = new Artist();

        if (webServiceArtistResponse.getResultCount() > 0) {
            for (ITunesWebServiceArtistResponse.Result apiResult : webServiceArtistResponse.getResults()) {
                if (apiResult.getWrapperType().equals(ITunesWebServiceArtistResponse.WRAPPER_TYPE_ARTIST)) {
                    artist.setArtistName(apiResult.getArtistName());
                }
                else if (apiResult.getWrapperType().equals(ITunesWebServiceArtistResponse.WRAPPER_TYPE_COLLECTION)) {
                    Album album = new Album();
                    album.setAlbumName(apiResult.getCollectionName());
                    album.setCoverImageUrl(apiResult.getArtworkUrl100());
                    try {
                        album.setReleaseDate(dateFormat.parse(apiResult.getReleaseDate()));
                    } catch (ParseException e) {
                        album.setReleaseDate(null);
                        Log.e("Error Parsing Date", e.getMessage());
                    }
                    artist.addAlbum(album);
                }
            }
        }
        return artist;
    }
}
