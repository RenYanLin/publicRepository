package com.ryl.app.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ryl on 2016/10/31.
 */

public class ToastUtils {
    private static Toast toast;
    public static void show(Context context,String content){
        if (toast==null){
            toast = Toast.makeText(context,content,Toast.LENGTH_SHORT);
        }else{
            toast.setText(content);
        }
        toast.show();
    }
}
