package com.example.yangbin.myviewpractice.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by yangbin on 2018/9/12.
 */
public class MyTextView  extends android.support.v7.widget.AppCompatTextView{


    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        canvas.save();
        canvas.translate(10,10);
        super.onDraw(canvas);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),paint);
        canvas.restore();
    }
}
