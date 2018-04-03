package com.ryl.app.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;


/**
 * Created by ryl on 2016/10/31.
 * 2017
 */

public abstract class BaseActivity extends FragmentActivity {
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("BaseActivity",getClass().getName());
        initView();
        initialization();
        loadData();
        initListener();
    }

    public void showProgressDialogNotAsk() {
        try {
            if (mProgressDialog == null) {
                mProgressDialog = new ProgressDialog(this);
                mProgressDialog.setMessage("正在加载...");
                mProgressDialog.setCanceledOnTouchOutside(false);
            }
            mProgressDialog.show();
        } catch (Exception e) {
        }
    }

    public void dissmissProgressDialogNotAsk() {
        try {
            if (mProgressDialog != null) {
                mProgressDialog.dismiss();
            }
        } catch (Exception e) {
        }
    }
    protected abstract void initialization();
    protected abstract void initView();
    protected abstract void loadData();
    protected abstract void initListener();
}
