package com.namshi.crashdroid.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * ScrollView which should throw "pointer index out of range" exception on usage.
 * Created by vgaidarji on 10/16/15.
 */
public class CustomScrollView extends ScrollView{
    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        float x = ev.getX(-1);
        float y = ev.getY(-1);
        return super.onInterceptTouchEvent(ev);
    }
}
