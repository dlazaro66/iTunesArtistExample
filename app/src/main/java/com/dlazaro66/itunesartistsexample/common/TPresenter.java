package com.dlazaro66.itunesartistsexample.common;

/**
 * Created by david on 10/6/15.
 */
public interface TPresenter<T> {

    public void onViewReady(T view);
    public void onDetachedView();
}
