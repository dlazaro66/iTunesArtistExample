package com.dlazaro66.itunesartistsexample.common;

import java.lang.ref.WeakReference;

/**
 * @description Base Presenter
 * Created by david on 10/6/15.
 */
public class BasePresenter<T> implements TPresenter<T> {

    private WeakReference<T> viewRef;

    @Override
    public void onViewReady(T view) {
        viewRef = new WeakReference<T>(view);
    }

    @Override
    public void onDetachedView() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }

    protected T getView() {
        return viewRef.get();
    }

    protected boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }
}
