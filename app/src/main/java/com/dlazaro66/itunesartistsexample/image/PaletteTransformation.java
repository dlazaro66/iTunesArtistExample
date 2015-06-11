package com.dlazaro66.itunesartistsexample.image;

import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;

import com.squareup.picasso.Transformation;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by david on 11/6/15.
 * @see "http://jakewharton.com/coercing-picasso-to-play-with-palette/"
 */
public final class PaletteTransformation implements Transformation {
    private static final PaletteTransformation INSTANCE = new PaletteTransformation();
    private static final Map<Bitmap, Palette> CACHE = new WeakHashMap<>();

    public static PaletteTransformation instance() {
        return INSTANCE;
    }

    public static Palette getPalette(Bitmap bitmap) {
        return CACHE.get(bitmap);
    }

    private PaletteTransformation() {}

    @Override public Bitmap transform(Bitmap source) {
        if (!CACHE.containsKey(source)) {
            Palette.Builder paletteBuilder = Palette.from(source);
            Palette palette = paletteBuilder.generate();
            CACHE.put(source, palette);
        }
        return source;
    }

    @Override
    public String key() {
        return "PaletteTransformation";
    }
}
