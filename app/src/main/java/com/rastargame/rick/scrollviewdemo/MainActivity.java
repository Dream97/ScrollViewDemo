package com.rastargame.rick.scrollviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private MyScrollView mMyScrollView;
    ImageView mIvBackground;
    private boolean first = true;
    private int mInitWidth;
    private int mInitHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mMyScrollView = findViewById(R.id.sv_test);
        mIvBackground = findViewById(R.id.iv_bg);
        mMyScrollView.setListener(new MyScrollView.SvListener() {
            @Override
            public void onChange(float t) {
                if (-t > 0) {
                    setZoom(-t);
                }
            }
        });
    }


    /**
     * 拉伸图片
     * @param t 滑动的高度
     */
    private void setZoom(float t) {
        ViewGroup.LayoutParams layoutParams = mIvBackground.getLayoutParams();
        if (first) { //保证获取到原来的长度
            mInitHeight = mIvBackground.getMeasuredHeight();
            mInitWidth = mIvBackground.getMeasuredWidth();
            first = false;
        }
        if (mInitHeight != 0 && mInitWidth != 0 ) {
            layoutParams.height = (int)(mInitHeight + t);
            layoutParams.width = (int)(mInitWidth * ((mInitHeight + t) / mInitHeight));
            mIvBackground.setLayoutParams(layoutParams);
        }
    }
}
