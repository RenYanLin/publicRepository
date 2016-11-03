package com.ryl.app.utils;

import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;

/**
 * Created by ryl on 2016/11/1.
 */

public class ImageLoaderController {
    public static DisplayImageOptions getOptions(int emptyImageId){
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(emptyImageId)
                .showImageForEmptyUri(emptyImageId)
                .bitmapConfig(Bitmap.Config.RGB_565)
                // 防止内存溢出
                .showImageOnFail(emptyImageId)
                .cacheInMemory(true)//R.drawable.ic_load
                .cacheOnDisk(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .delayBeforeLoading(0)//等待多少秒加载
                .displayer(new SimpleBitmapDisplayer())
                .build();
        return options;
    }
}
