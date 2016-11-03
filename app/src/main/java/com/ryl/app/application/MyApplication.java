package com.ryl.app.application;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.ryl.app.MainActivity;

import java.lang.ref.WeakReference;

/**
 * Created by ryl on 2016/10/31.
 */

public class MyApplication extends Application {

    public static Context CONTEXT;
    public static RequestQueue mQueue;
    public static MyApplication application;
    @Override
    public void onCreate() {
        super.onCreate();
        CONTEXT = getApplicationContext();
        application = this;
        mQueue = Volley.newRequestQueue(this);
        initImageLoader(getApplicationContext());
        Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler());
    }

    public static RequestQueue getHttpRequest(){
        if (mQueue==null){
            mQueue = Volley.newRequestQueue(CONTEXT);
        }
        return mQueue;
    }

    public static void initImageLoader(Context context) {
        // This configuration tuning is custom. You can tune every option, you may tune some of them,
        // or you can create default configuration by
        //  ImageLoaderConfiguration.createDefault(this);
        // method.
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs(); // Remove for release app

        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());
    }

    private class MyExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread thread, Throwable ex) {
            //启动首页
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            PendingIntent restartIntent = PendingIntent.getActivity(CONTEXT, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            //退出程序
            AlarmManager mgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 1000, restartIntent);
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }
}
