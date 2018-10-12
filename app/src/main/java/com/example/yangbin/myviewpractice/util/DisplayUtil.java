package com.example.yangbin.myviewpractice.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;

/**
 * dp 、sp 转换为PX的工具类
 */
public class DisplayUtil {

    /**
     *
     * @param context
     * @param pxValue px值
     * scale DisplayMetrics类中的density 属性
     * @return dip 值
     */
    public static int px2dip(Context context,float pxValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue/scale+0.5f);
    }

    public static int dip2px(Context context,float dpValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue*scale+0.5f);
    }


    public static int px2sp(Context context,float pxValue){
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue/scale+0.5f);
    }

    public static int sp2px(Context context,float spValue){
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue*scale+0.5f);
    }
}
