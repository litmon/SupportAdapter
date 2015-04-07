package com.example.fukuo.supportadapter;

import android.view.View;

/**
 * Created by fukuo on 2015/04/07.
 */
abstract class ViewHolder<T> {
    protected ViewHolder(View v) {
        findViews(v);
        v.setTag(this);
    }

    abstract protected void findViews(View v);
    abstract public void bindItem(T item);
}