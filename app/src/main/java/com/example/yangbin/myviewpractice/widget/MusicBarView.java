package com.example.yangbin.myviewpractice.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

import java.util.Random;

/**
 * Created by yangbin on 2018/9/13.
 */
public class MusicBarView extends View {
    private float mHeight;
    private LinearGradient mLinearGradient;
    public MusicBarView(Context context) {
        this(context,null);
    }

    public MusicBarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MusicBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public MusicBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(final Canvas canvas) {

        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setShader(mLinearGradient);
        for(int i = 0 ; i < 6 ; i++){
            Random random = new Random();
            mHeight = random.nextInt(getHeight());
            mLinearGradient = new LinearGradient(0,0,getWidth(),getHeight(), Color.BLUE,Color.GREEN, Shader.TileMode.CLAMP);
            canvas.drawRect(getWidth()/2-6*120/2+20+i*100+(i+1)*20,getHeight() - mHeight,getWidth()/2-6*120/2+20+(i+1)*120,getWidth(),paint);
        }

        postInvalidateDelayed(200);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //首先获取当前事件的速度
        VelocityTracker velocityTracker = VelocityTracker.obtain();
        velocityTracker.addMovement(event);
        //设置一个时间段单位毫秒这样获取到的速度就是这个时间段类的像素移动个数
        velocityTracker.computeCurrentVelocity(1000);
        //得到的这个速度可以为负值只要是逆坐标系运动就是负值
        int xVelocity = (int) velocityTracker.getXVelocity();
        int yVelocity = (int) velocityTracker.getYVelocity();

        //最后再不需要使用的时候 调用clear() 方法来重置并会后内存
        velocityTracker.clear();
        velocityTracker.recycle();
        return super.onTouchEvent(event);
    }
}
