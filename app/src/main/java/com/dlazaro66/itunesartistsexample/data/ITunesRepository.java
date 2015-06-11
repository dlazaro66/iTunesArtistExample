package com.dlazaro66.itunesartistsexample.data;

import com.dlazaro66.itunesartistsexample.common.Callback;
import com.dlazaro66.itunesartistsexample.model.Artist;

import java.util.List;

/**
 * Repository where we will query for data, I should not know if data is provided by a cache, by a network connection or whatever
 * Created by david on 10/6/15.
 */
public interface ITunesRepository {

    void getArtists(Callback<List<Artist>> callback);
}
