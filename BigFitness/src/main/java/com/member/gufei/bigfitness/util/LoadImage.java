package com.member.gufei.bigfitness.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.member.gufei.bigfitness.R;
import com.member.gufei.bigfitness.util.NgCommon.util.Utils;

import static com.member.gufei.bigfitness.Constants.BASEURL;
import static com.member.gufei.bigfitness.Constants.IMGURL;


/**
 * Created by tre on 16/9/26.
 * <p>
 * 图片加载项
 */

public abstract class LoadImage {


//    /**
//     * 图片加载
//     * * @param context 父容器;
//     * * @param imageUrl 图片地址;
//     * * @param errorImageId 错误图片;
//     * * @param imageView 显示容器;
//     */
//    public static void loadIntoUseFitWidth(Context context, final String imageUrl, int errorImageId, final ImageView imageView) {
//        RequestOptions options = new RequestOptions();
//        options.centerCrop()
//                .placeholder(errorImageId)//占位
//                .error(errorImageId)
//                .fallback(errorImageId);
//
//
//        Glide.with(context)
//                .load(BASEURL + imageUrl)
//                .apply(options)
//                .into(imageView);
//    }

    public static void ImagLoader(Context context, final String imageUrl, final int errorImageId, final ImageView imageView) {
        RequestOptions options = new RequestOptions();
        options.centerCrop()
                .placeholder(errorImageId)//占位
                .error(errorImageId)
                .fallback(errorImageId);


        Glide.with(context)
                .load(imageUrl)
                .apply(options)
                .into(imageView);
    }

    /**
     * 图片加载
     * * @param context 父容器;
     * * @param imageUrl 图片地址;
     * //     ** @param errorImageId 错误图片;
     * * @param imageView 显示容器;
     */
    public static void loadBgImg(Context context, final String imageUrl, final int errorImageId, final ImageView imageView) {

        imageView.setVisibility(View.VISIBLE);

        RequestOptions options = new RequestOptions();
        options.centerCrop()
                .placeholder(errorImageId)//占位
                .error(errorImageId)
                .fallback(errorImageId);


        Glide.with(context)
                .load(IMGURL + "/" + imageUrl)
                .apply(options)
                .into(imageView);
    }

    /**
     * 圆形图片加载
     * * @param context 父容器;
     * * @param imageUrl 图片地址;
     * //     ** @param errorImageId 错误图片;
     * * @param imageView 显示容器;
     */
    public static void loadImgForRadius(Context context, final String imageUrl, final int errorImageId, final ImageView imageView) {


        RequestOptions options = new RequestOptions();

        options.placeholder(errorImageId)//占位
                .error(errorImageId)
                .fallback(errorImageId);
        options.transform(new CenterCropRoundCornerTransform());
        Glide.with(context)
                .load(IMGURL + "/" + imageUrl)
                .apply(options)
                .into(imageView);


    }

    /**
     * 圆形图片本地加载
     * * @param context 父容器;
     * * @param imageUrl 图片地址;
     * //     ** @param errorImageId 错误图片;
     * * @param imageView 显示容器;
     */

    public static void loadImgForRadius1(Context context, final String imageUrl, final int errorImageId, final ImageView imageView) {


        RequestOptions options = new RequestOptions();

        options.placeholder(errorImageId)//占位
                .error(errorImageId)
                .fallback(errorImageId);
        options.transform(new CenterCropRoundCornerTransform());
        Glide.with(context)
                .load(imageUrl)
                .apply(options)
                .into(imageView);


    }

    public static class CenterCropRoundCornerTransform extends CenterCrop {

        private int radius = 0;
//
//        public CenterCropRoundCornerTransform(int radius) {
//            this.radius = radius;
//        }

        @Override
        protected Bitmap transform(BitmapPool pool, Bitmap toTransform,
                                   int outWidth, int outHeight) {
            Bitmap transform = super.transform(pool, toTransform, outWidth, outHeight);
            return roundCrop(pool, transform);
        }

        private Bitmap roundCrop(BitmapPool pool, Bitmap source) {
            if (source == null)
                return null;
            Bitmap result = pool.get(source.getWidth(), source.getHeight(),
                    Bitmap.Config.ARGB_8888);

            radius = result.getWidth() / 2;

            if (result == null) {
                result = Bitmap.createBitmap(source.getWidth(), source.getHeight(),
                        Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP,
                    BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
            canvas.drawRoundRect(rectF, radius, radius, paint);
            return result;
        }

    }


//    public static void loadIntoUsecenterCrop(Context context, final String imageUrl, int errorImageId, final ImageView imageView) {
//
//        Glide.with(context)
//                .load(imageUrl)
//                .crossFade()
//                .dontAnimate()
////                .centerCrop()
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .listener(new RequestListener<String, GlideDrawable>() {
//
//                    @Override
//                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
//
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//
//                        if (imageView == null) {
//                            return false;
//                        }
//                        if (imageView.getScaleType() != ImageView.ScaleType.FIT_XY) {
//                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//                        }
//                        ViewGroup.LayoutParams params = imageView.getLayoutParams();
//                        int vw = imageView.getWidth() - imageView.getPaddingLeft() - imageView.getPaddingRight();
//                        float scale = (float) vw / (float) resource.getIntrinsicWidth();
//                        int vh = Math.round(resource.getIntrinsicHeight() * scale);
//                        params.height = vh + imageView.getPaddingTop() + imageView.getPaddingBottom();
//                        imageView.setLayoutParams(params);
//                        return false;
//                    }
//                })
//                .placeholder(errorImageId)
//                .error(errorImageId)
//                .into(imageView);
//    }


}
