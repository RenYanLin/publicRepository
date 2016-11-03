package com.ryl.app.volley;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.ryl.app.application.MyApplication;

import java.util.Map;

/**
 * Created by ryl on 2016/11/2.
 */

public class VolleyRequest {

    public static StringRequest stringRequest;
    public static void RequestGet(String url,String tag,VolleyInterface vif){
        //防止重复请求，所以先取消tag标识的请求队列
        MyApplication.getHttpRequest().cancelAll(tag);
        stringRequest=new StringRequest(Request.Method.GET, url,
                vif.loadingListener(),
                vif.errorListener()
        );
        stringRequest.setTag(tag);
        MyApplication.getHttpRequest().add(stringRequest);
    }
    public static void RequestPost(String url,String tag,final Map<String, String> params,
                                   VolleyInterface vif){
        MyApplication.getHttpRequest().cancelAll(tag);
        stringRequest = new StringRequest(url, vif.loadingListener(), vif.errorListener()){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        stringRequest.setTag(tag);
        MyApplication.getHttpRequest().add(stringRequest);
    }
}
