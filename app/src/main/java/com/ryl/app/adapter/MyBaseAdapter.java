package com.ryl.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by ryl on 2016/10/31.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {
    private Context context;
    private ArrayList<T> list;
    private int itemLayoutResId;

    public MyBaseAdapter(Context context, int itemLayoutResId, ArrayList<T> list) {
        this.context = context;
        this.list = list;
        this.itemLayoutResId = itemLayoutResId;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = ViewHolder.getViewHolder(context, itemLayoutResId, i, view, viewGroup);
        convert(viewHolder,list.get(i));
        return viewHolder.getConvertView();
    }

    public abstract void convert(ViewHolder viewHolder, T item);

}