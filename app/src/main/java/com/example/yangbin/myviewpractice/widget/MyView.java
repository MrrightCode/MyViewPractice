package com.example.yangbin.myviewpractice.widget;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.icu.util.Measure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.yangbin.myviewpractice.R;

/**
 * Created by yangbin on 2018/9/12.
 */
public class MyView extends View{
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0,0,100,100,new Paint());
        super.onDraw(canvas);
        Paint paint = new Paint();
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.point),0,0,paint);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.store),0,500,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
