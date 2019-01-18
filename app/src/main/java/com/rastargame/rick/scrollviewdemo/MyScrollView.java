package com.rastargame.rick.scrollviewdemo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

/**
 * Author: Rick
 * Email: zhiyuanfeng@rastar.com
 * Date: 2019/1/18
 */
public class MyScrollView extends ScrollView {
    private SvListener mSvListener;
    public MyScrollView(Context context) {
        super(context, null);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                break;
        }
        return super.onTouchEvent(ev);
    }

    /**
     * ScrollView 滑动时调用该方法
     * @param l 变化后的X轴位置
     * @param t 变化后的Y轴的位置
     * @param oldl 原先的X轴的位置
     * @param oldt 原先的Y轴的位置
     */
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        mSvListener.onChange(t);
        super.onScrollChanged(l, t, oldl, oldt);
    }

    public void setListener(SvListener svListener) {
        this.mSvListener = svListener;
    }

    public interface SvListener{
        void onChange(float t);
    }
}
