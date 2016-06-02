package com.shbd.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
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
        TranslateAnimation animation = new TranslateAnimation(-100, 0, 0, 0);
        animation.setDuration(3000);
        animation.setFillAfter(true);

        mImageView.startAnimation(animation);
    }

    public void translation2(View view) {
        /**
         * Animation.RELATIVE_TO_SELF:
         * fromXValue:x坐标的起点位置，如果相对于自己，传0.5f，那么起点坐标就是 真实X + 0.5 * iv宽度
         * toXValue: x坐标的终点位置，如果传入2，那么终点坐标就是 真实X + 2 * iv的宽度
         * fromYValue:y坐标的起点位置，如果传入0.5f，那么起点坐标就是 真实Y + 0.5 * iv高度
         * toYValue:y坐标的终点位置，如果传入2，那么终点坐标就是 真实Y + 2 * iv高度
         *
         * Animation.RELATIVE_TO_PARENT:
         * 将以上iv的宽高改为父控件的宽高
         **/
        TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                -2f, Animation.RELATIVE_TO_SELF, 2f, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
        animation.setDuration(3000);
        /**
         * 动画播放完毕后，组件停留在动画结束的位置上
         */
        animation.setFillAfter(true);
        /**
         *动画重复播放的次数
         */
        animation.setRepeatCount(2);
        /**
         *动画效果的重复模式:
         * RESTART：重新从头开始执行。
         * REVERSE：反方向执行。
         */
        animation.setRepeatMode(Animation.REVERSE);
        mImageView.startAnimation(animation);
    }

    public void scale1(View view){
        /**
         * 参数0.5f表示动画的起始宽度是真实宽度的0.5倍
         * 参数2表示动画的结束宽度是真实宽度的2倍
         *
         * 最后两个参数表示缩放的中心点：
          *中心点x坐标 = 真实X +mImageView.getWidth()/2
         * 中心点Y坐标 = 真实Y +mImageView.getHeight()/2
         */
        ScaleAnimation animation=new ScaleAnimation(0.5f,2f,0.5f,2f,mImageView.getWidth()/2,mImageView.getHeight()/2);
        animation.setFillAfter(true);
        animation.setDuration(3000);
        mImageView.startAnimation(animation);
    }

    public void scale2(View view){
        /**
         * 最后两个参数表示缩放的中心点：
         * 传入的两个0.5f，类型都是相对于自己，这两个参数改变了缩放的中心点
         * 中心点x坐标 = 真实X + 0.5 * iv宽度
         * 中心点Y坐标 = 真实Y + 0.5 * iv高度
         */
        ScaleAnimation animation=new ScaleAnimation(0.5f,2f,0.5f,2f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setFillAfter(true);
        animation.setDuration(3000);
        mImageView.startAnimation(animation);
    }

    public void alpha(View view){
        /**
         * 0：完全透明
         * 1：完全不透明
         */
        AlphaAnimation animation=new AlphaAnimation(0,1f);
        animation.setFillAfter(true);
        animation.setDuration(3000);
        mImageView.startAnimation(animation);
    }

    public void rotate(View view){
/*
        RotateAnimation animation=new RotateAnimation(0,360,mImageView.getWidth()/2,mImageView.getHeight()/2);
*/
        RotateAnimation animation=new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setFillAfter(true);
        animation.setDuration(3000);
        mImageView.startAnimation(animation);
    }

    public void playAll(View view){
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                -2f, Animation.RELATIVE_TO_SELF, 2f, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);

        ScaleAnimation scaleAnimation=new ScaleAnimation(0.5f,2f,0.5f,2f,mImageView.getWidth()/2,mImageView.getHeight()/2);

        RotateAnimation rotateAnimation=new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);

        AnimationSet set=new AnimationSet(true);
        set.addAnimation(translateAnimation);
        set.addAnimation(scaleAnimation);
        set.addAnimation(rotateAnimation);

        set.setDuration(3000);
        set.setFillAfter(true);
        mImageView.startAnimation(set);
    }

    public void playAllByXml(View view){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanim);
        mImageView.startAnimation(animation);
    }

}
