package com.dlazaro66.itunesartistsexample.data;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by david on 10/6/15.
 */
public interface ITunesService {

    @GET("/lookup?entity=album&media=music")
    void queryForArtist(@Query("id") int id,@Query("limit") int limit, Callback<ITunesWebServiceArtistResponse> callback);

    @GET("/lookup?entity=album&media=music")
    Observable<ITunesWebServiceArtistResponse> queryForArtist(@Query("id") int id,@Query("limit") int limit);
}
