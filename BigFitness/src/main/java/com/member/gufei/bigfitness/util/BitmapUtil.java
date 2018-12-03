package com.member.gufei.bigfitness.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 图片处理工具类
 *
 * @author GuFei
 * @version 2016 09 06 14:59
 */
public class BitmapUtil {

    /**
     * 计算图片 inSampleSize
     *
     * @param options   options
     * @param reqWidth  宽度
     * @param reqHeight 高度
     * @return inSampleSize
     */
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int width = options.outWidth;
        int height = options.outHeight;
        int inSampleSize = 1;

        if (width > reqWidth || height > reqHeight) {
            final int halfWidth = width / 2;
            final int halfHeight = height / 2;

            while (halfWidth / inSampleSize > reqWidth && halfHeight / inSampleSize > reqHeight) {
                inSampleSize *= 2;
            }
        }
        // 缩略比例
        return inSampleSize;
    }

    /**
     * 按指定大小解析图片
     *
     * @param res       资源
     * @param resId     ID
     * @param reqWidth  宽
     * @param reqHeight 高
     * @return 图片
     */
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        // 可以在解码的时候避免内存的分配，它会返回一个null的Bitmap，
        // 但是可以获取到 outWidth, outHeight 与 outMimeType。
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeResource(res, resId, options);
    }

    /**
     * 通过Base32将Bitmap转换成Base64字符串
     *
     * @param url
     * @return
     */
    public static String Bitmap2StrByBase64(String url) {

        String TypeName = getImageType(url);
        String TypeNameStr = "";

        Bitmap bit = BitmapFactory.decodeFile(url);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        if (TypeName.equals("jpg")) {
            bit.compress(Bitmap.CompressFormat.JPEG, 40, bos);//参数100表示不压缩
            TypeNameStr = "data:image/jpeg;base64,";
        } else if (TypeName.equals("png")) {
            bit.compress(Bitmap.CompressFormat.PNG, 40, bos);//参数100表示不压缩
            TypeNameStr = "data:image/png;base64,";
        } else if (TypeName.equals("gif")) {
            bit.compress(Bitmap.CompressFormat.JPEG, 40, bos);//参数100表示不压缩
            TypeNameStr = "data:image/jpeg;base64,";
        } else if (TypeName.equals("89504E")) {
            TypeNameStr = "data:image/jpeg;base64,";
            bos = convertToJpg(url);
        }


        byte[] bytes = bos.toByteArray();

        String s = TypeNameStr + Base64.encodeToString(bytes, Base64.DEFAULT);
        return s;
    }

    /**
     * 获取文件类型
     *
     * @param filePath
     * @return
     */
    public static String getImageType(String filePath) {
        FileInputStream is = null;
        String value = null;
        try {
            is = new FileInputStream(filePath);
            byte[] b = new byte[3];
            is.read(b, 0, b.length);
            value = bytesToHexString(b);
        } catch (Exception e) {
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
        }
        if ("FFD8FF".equals(value)) {
            return "jpg";
        } else if ("FFD8FF".equals(value)) {
            return "jpg";
        } else if ("47494638".equals(value)) {
            return "gif";
        } else if ("424D".equals(value)) {
            return "bmp";
        } else if ("89504E47".equals(value)) {
            return "png";
        }
        return value;
    }

    private static String bytesToHexString(byte[] src) {
        StringBuilder builder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        String hv;
        for (int i = 0; i < src.length; i++) {
            hv = Integer.toHexString(src[i] & 0xFF).toUpperCase();
            if (hv.length() < 2) {
                builder.append(0);
            }
            builder.append(hv);
        }
        return builder.toString();
    }

    public static ByteArrayOutputStream convertToJpg(String pngFilePath) {
        Bitmap bitmap = BitmapFactory.decodeFile(pngFilePath);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 40, bos);
        return bos;
//        ufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(jpgFilePath))) {
//            if () {
//                return  bos;
////                bos.flush();
//            }
//
    }
}