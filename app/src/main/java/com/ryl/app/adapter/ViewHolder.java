package com.ryl.app.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ryl on 2016/10/31.
 */

public class ViewHolder {
    private SparseArray<View> views = null;
    private View convertView = null;
    private int position = 0;

    private ViewHolder(Context context, int itemLayoutResId, int position, ViewGroup parent){
        this.views = new SparseArray<>();
        this.position = position;
        this.convertView = LayoutInflater.from(context).inflate(itemLayoutResId,parent);
        convertView.setTag(this);
    }

    public static ViewHolder getViewHolder(Context context,int itemLayoutResId,int position,View convertView, ViewGroup parent){
        if (convertView == null){
            return new ViewHolder(context,itemLayoutResId,position,parent);
        }else {
            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.position = position;
            return viewHolder;
        }
    }

    public View getConvertView() {
        return convertView;
    }

    public <T extends View> T getView(int viewResId){
        View view = views.get(viewResId);

        if (view==null){
            view = convertView.findViewById(viewResId);
            views.put(viewResId,view);
        }

        return (T) view;
    }
}
