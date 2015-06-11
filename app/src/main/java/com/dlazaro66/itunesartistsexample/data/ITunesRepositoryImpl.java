package com.dlazaro66.itunesartistsexample.data;

import com.dlazaro66.itunesartistsexample.common.Callback;
import com.dlazaro66.itunesartistsexample.model.Artist;

import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.observers.Subscribers;
import rx.schedulers.Schedulers;

/**
 * Created by david on 10/6/15.
 *
 * @description Implements the iTunesRepository using Retrofit and iTunes REST Api
 */
public class ITunesRepositoryImpl implements ITunesRepository {

    @Override
    public void getArtists(final Callback<List<Artist>> callback) {

        getArtistAsyncRx(callback);
        //getArtistAsync(callback);
    }

    private void getArtistAsyncRx(final Callback<List<Artist>> callback) {
        final int ARTIST_ID_1 = 148662;
        final int ARTIST_ID_2 = 6906197;
        final int ARTIST_ID_3 = 16252655;
        final int ARTIST_LIMIT_1 = 10;
        final int ARTIST_LIMIT_2 = 20;
        final int ARTIST_LIMIT_3 = 7;

        final List<ITunesWebServiceArtistResponse> apiArtistResponse = new ArrayList<>();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://itunes.apple.com")
                .build();
        final ITunesService service = restAdapter.create(ITunesService.class);

        Observable<ITunesWebServiceArtistResponse> query1 = service.queryForArtist(ARTIST_ID_1, ARTIST_LIMIT_1);
        Observable<ITunesWebServiceArtistResponse> query2 = service.queryForArtist(ARTIST_ID_2, ARTIST_LIMIT_2);
        Observable<ITunesWebServiceArtistResponse> query3 = service.queryForArtist(ARTIST_ID_3, ARTIST_LIMIT_3);

        Subscriber onComplete = Subscribers.create(new Action1<ITunesWebServiceArtistResponse>() {
            @Override
            public void call(ITunesWebServiceArtistResponse iTunesWebServiceArtistResponse) {
                apiArtistResponse.add(iTunesWebServiceArtistResponse);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                callback.onFailure(throwable);
            }
        }, new Action0() {
            @Override
            public void call() {
                callback.onSuccess(ApiDomainToModelDomainMapper.map(apiArtistResponse));
            }
        });


        Observable.concat(query1, query2, query3)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onComplete);
    }

    /**
     * I did not remove this method only to compare between RxJava and a simple Callback.
     * @param callback
     */
    private void getArtistAsync(final Callback<List<Artist>> callback) {
        final int ARTIST_ID_1 = 148662;
        final int ARTIST_ID_2 = 6906197;
        final int ARTIST_ID_3 = 16252655;
        final int ARTIST_LIMIT_1 = 10;
        final int ARTIST_LIMIT_2 = 20;
        final int ARTIST_LIMIT_3 = 7;

        final List<ITunesWebServiceArtistResponse> apiArtistResponse = new ArrayList<>();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://itunes.apple.com")
                .build();

        final ITunesService service = restAdapter.create(ITunesService.class);
        service.queryForArtist(ARTIST_ID_1, ARTIST_LIMIT_1, new retrofit.Callback<ITunesWebServiceArtistResponse>() {
            @Override
            public void success(ITunesWebServiceArtistResponse iTunesWebServiceArtistResponse_1, Response response) {
                apiArtistResponse.add(iTunesWebServiceArtistResponse_1);
                service.queryForArtist(ARTIST_ID_2, ARTIST_LIMIT_2, new retrofit.Callback<ITunesWebServiceArtistResponse>() {
                    @Override
                    public void success(ITunesWebServiceArtistResponse iTunesWebServiceArtistResponse_2, Response response) {
                        apiArtistResponse.add(iTunesWebServiceArtistResponse_2);
                        service.queryForArtist(ARTIST_ID_3, ARTIST_LIMIT_3, new retrofit.Callback<ITunesWebServiceArtistResponse>() {
                            @Override
                            public void success(ITunesWebServiceArtistResponse iTunesWebServiceArtistResponse_3, Response response) {
                                apiArtistResponse.add(iTunesWebServiceArtistResponse_3);
                                callback.onSuccess(ApiDomainToModelDomainMapper.map(apiArtistResponse));
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                callback.onFailure(error);
                            }
                        });
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        callback.onFailure(error);
                    }
                });
            }

            @Override
            public void failure(RetrofitError error) {
                callback.onFailure(error);
            }
        });
    }
}
