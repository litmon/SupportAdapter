package com.example.fukuo.supportadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by fukuo on 2015/04/06.
 */
public class SupportAdapter extends ArrayAdapter {

    int resourceId;
    LayoutInflater inflater;

    Constructor<? extends ViewHolder> constructor;

    public SupportAdapter(Context context, int resource) {
        super(context, resource);

        resourceId = resource;
        inflater = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(resourceId, null);
            holder = createViewHolder(convertView);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        if (holder != null){
            holder.bindItem(getItem(position));
        }

        return convertView;
    }

    public void setViewHolder(Class<? extends ViewHolder> holderClass) {
        constructor = null;
        try {
            constructor = holderClass.getDeclaredConstructor(View.class);
            constructor.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public ViewHolder createViewHolder(View view) {
        ViewHolder holder = null;

        try {
            holder = constructor.newInstance(view);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return holder;
    }
}
