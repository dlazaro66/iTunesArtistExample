package com.dlazaro66.itunesartistsexample.common;

/**
 * Created by david on 10/6/15.
 */
public interface Callback<T> {

    public void onSuccess(T result);
    public void onFailure(Throwable error);
}
