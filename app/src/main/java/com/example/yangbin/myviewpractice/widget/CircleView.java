package com.example.yangbin.myviewpractice.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.yangbin.myviewpractice.R;

/**
 * Created by yangbin on 2018/9/13.
 */
public class CircleView extends View {
    private float startAngle;
    private float sweepAngle;
    private int color;
    private ObjectAnimator mObjectAnimator;
    private int mHeight;
    private int mWidth;


    public float getSweepAngle() {
        return sweepAngle;
    }

    public void setSweepAngle(float sweepAngle) {
        this.sweepAngle = sweepAngle;
        invalidate();
    }

    public CircleView(Context context) {
        this(context,null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        startAngle = array.getFloat(R.styleable.CircleView_stratAgle,270);
        mObjectAnimator = ObjectAnimator.ofFloat(this,"sweepAngle",0,array.getFloat(R.styleable.CircleView_sweepAgle,0));
        color = array.getColor(R.styleable.CircleView_color,Color.BLACK);
        mObjectAnimator.setDuration(10000);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(color);
        paint.setShader(new LinearGradient(0,0,mWidth,mHeight,Color.BLUE,Color.YELLOW, Shader.TileMode.CLAMP));
        canvas.drawCircle(mWidth/2,mHeight/2,getRadius(),paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(getRadius()/4);
        canvas.drawArc(mWidth/2-getRadius()*5/4,mHeight/2-getRadius()*5/4,
                mWidth/2+getRadius()*5/4,mHeight/2+getRadius()*5/4,
                        startAngle, sweepAngle,false,paint);

    }

    //在onMeasure中做处理来支持Wrap_content属性
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int mWidth  = 400;
        int mHeight = 400;

        if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT && getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(mWidth, mHeight);
            // 宽 / 高任意一个布局参数为= wrap_content时，都设置默认值
        } else if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(mWidth, heightSize);
        } else if (getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(widthSize, mHeight);
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mObjectAnimator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mObjectAnimator.end();
    }

    public float getRadius() {
        float radius;
        mHeight = getHeight() - getPaddingBottom() - getPaddingTop();
        mWidth = getWidth() - getPaddingLeft()- getPaddingRight();
        if(mWidth > mHeight){
            radius = mHeight/3;
        }else {
            radius = mWidth/3;
        }
        return radius;
    }
}
