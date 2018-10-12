package com.example.yangbin.myviewpractice.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by yangbin on 2018/9/18.
 */
public class SurfaceViewPractice extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private SurfaceHolder mSurfaceHolder;
    private Canvas mCanvas;
    private Path mPath;
    private Paint mPaint;
    /**
     * 控制绘画线程的标志位
     */
    private boolean mIsDrawing;
    //每隔30毫秒刷新一次
    public static final int TIME_IN_FRAME = 30;

    public SurfaceViewPractice(Context context) {
        this(context, null);
    }

    public SurfaceViewPractice(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SurfaceViewPractice(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        this.setKeepScreenOn(true);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsDrawing = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder,
                               int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsDrawing = false;
    }

    @Override
    public void run() {
        //在这里可以通过线程控制图像的刷新频率
        long startTime = System.currentTimeMillis();
        while (mIsDrawing) {
            //获取刷新前的时间
            synchronized (mSurfaceHolder) {
                //拿到前画布然后锁定
                draw();
            }
        }

        //取得更新结束之后的时间
            long endTime = System.currentTimeMillis();

            //计算出一次跟新的时间
            int diffTime = (int) (endTime - startTime);

            //确保刷新的时间是30毫秒一次
            while (diffTime <= TIME_IN_FRAME) {
                diffTime = (int) (System.currentTimeMillis() - startTime);
                //线程的操作方法：yield()是暂停当前正在执行的线程对象，去操作其他线程
                //sleep()使当前线程暂停参数中指定的时间然后再继续执行线程
                Thread.yield();
            }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        return true;
    }

    public void draw() {
        try {
            /**
             * 在这里开始绘制的操作
             */
            mCanvas = mSurfaceHolder.lockCanvas();
            mCanvas.drawColor(Color.WHITE);
            mCanvas.drawPath(mPath,mPaint);
        } catch (Exception e) {
        } finally {
            if (mCanvas != null) {
                mSurfaceHolder.unlockCanvasAndPost(mCanvas);
            }
        }
    }
}
