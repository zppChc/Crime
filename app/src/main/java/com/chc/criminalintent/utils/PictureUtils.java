package com.chc.criminalintent.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * DESC: 图片工具类，用于处理图片问题
 * Author: CHC
 * Date: 2017/12/11
 */

public class PictureUtils {
    //静态Bitmap估算方法，
    @SuppressLint("NewApi")
    public static Bitmap getScaledBitmap(String path, Activity activity){
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);
        return getScaledBitmap(path, size.x, size.y);
    }
    //静态Bitmap计算方法
    public static Bitmap getScaledBitmap(String path, int destWidth, int destHeight){
        // Read in the dimensions of the image on disk
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path,options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        //Figure out how much to scale down by
        int inSampleSize =  1;
        if (srcHeight > destHeight || srcWidth>destWidth){
            if (srcWidth > srcHeight){
                inSampleSize=Math.round(srcHeight/destHeight);
            }else {
                inSampleSize=Math.round(srcWidth/destWidth);
            }
        }

        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;

        return  BitmapFactory.decodeFile(path,options);
    }
}
