package com.dlazaro66.itunesartistsexample.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by david on 10/6/15.
 * Facade for Async Image Loading
 * It doesn't matter if we change Picasso by Glide or whatever
 */
public class ImageLoader {

    public static void load(Context context,String url,ImageView imageView){

        if (url != null && imageView != null && context != null)
            Picasso.with(context).load(url).into(imageView);
    }
    public static void load(Context context,int resId,ImageView imageView){

        if (resId != 0) {
            Picasso.with(context).load(resId).into(imageView);
        }
    }

    public static void loadWithPalette(Context context,String url, final ImageView imageView, int colorPlaceholder,final com.dlazaro66.itunesartistsexample.common.Callback<Palette> callback){

        if (url != null && imageView != null && context != null) {
            Picasso.with(context).load(url)
                    .transform(PaletteTransformation.instance())
                    .placeholder(colorPlaceholder)
                    .into(imageView, new Callback.EmptyCallback() {
                        @Override
                        public void onSuccess() {
                            Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap(); // Ew!
                            Palette palette = PaletteTransformation.getPalette(bitmap);
                            callback.onSuccess(palette);
                        }
                    });
        }
    }

}