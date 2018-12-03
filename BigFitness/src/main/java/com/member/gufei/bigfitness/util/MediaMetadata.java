package com.member.gufei.bigfitness.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.RequestOptions;

import java.security.MessageDigest;
import java.util.HashMap;

import static com.bumptech.glide.load.resource.bitmap.VideoBitmapDecoder.FRAME_OPTION;

/**
 * Created by GuFei_lyf on 2017/6/1
 * <p>
 * 视频预览图生成类
 */

public class MediaMetadata {

    /**
     * 获取视频预览(为视频第一帧)
     * @param context
     * @param uri
     * @param imageView
     * @param frameTimeMicros
     */
    public static void loadVideoScreenshot(final Context context, String uri, ImageView imageView, long frameTimeMicros) {
        RequestOptions requestOptions = RequestOptions.frameOf(frameTimeMicros);
        requestOptions.set(FRAME_OPTION, MediaMetadataRetriever.OPTION_CLOSEST);
        requestOptions.transform(new BitmapTransformation() {
            @Override
            protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
                return toTransform;
            }
            @Override
            public void updateDiskCacheKey(MessageDigest messageDigest) {
                try {
                    messageDigest.update((context.getPackageName() + "RotateTransform").getBytes("utf-8"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Glide.with(context).load(uri).apply(requestOptions).into(imageView);
    }


}
