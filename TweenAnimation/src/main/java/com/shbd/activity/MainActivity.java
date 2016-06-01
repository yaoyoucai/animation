package com.shbd.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.imageView);
    }

    public void translation1(View view) {
        /**
         * 参1:fromXDelta:动画在x轴的开始位置:
         * 参2:toXDelta:动画在x轴的结束位置:
         * 参2:fromYDelta:动画在y轴的开始位置:
         * 参2:toYDelta:动画在y轴的结束位置:
         *
         * 注意：
         * 以上所有坐标不是指坐标为"fromXDelta"的位置:而是控件的真实坐标+fromXDelta;
         **/
        TranslateAnimation animation = new TranslateAnimation(-100, 100, -50, 50);
        animation.setFillAfter(true);
        mImageView.setAnimation(animation);
        animation.start();
    }
}
