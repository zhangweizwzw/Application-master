package com.yt.wia.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import com.yt.wia.view.ChartItem;

import java.util.List;

/**
 * Created by Administrator on 2016/4/26.
 */
public  class ChartDataAdapter extends ArrayAdapter<ChartItem> {

    public ChartDataAdapter(Context context, List<ChartItem> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItem(position).getView(position, convertView, getContext());
    }

    @Override
    public int getItemViewType(int position) {
        // return the views type
        return getItem(position).getItemType();
    }

    @Override
    public int getViewTypeCount() {
        return 3; // we have 3 different item-types
    }
}