package com.example.yangbin.myviewpractice.util;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by yangbin on 2018/9/17.
 */
public class GestureListener implements GestureDetector.OnGestureListener {
    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    //按下的时间超过瞬间，而且按下的时候没有松开或者拖动，那么这个函数就会执行
    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    //长按触屏超过一定时长，就会触发这个事件，触发的顺序 onDown->onShowPress->onLongPress
    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
