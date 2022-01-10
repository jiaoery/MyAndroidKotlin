package com.example.myandroidkotlin.watermark;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * 屏幕分辨率计算转换相关工具类
 * Created by coco on 2017/9/6.
 */

public class DensityUtil {

    // 当前屏幕的densityDpi
    private float dmDensityDpi = 0.0f;
    private DisplayMetrics dm;
    private float scale = 0.0f;

    private static DensityUtil instance;

    private int width;
    private int height;

    private DensityUtil(Context context) {
        // 获取当前屏幕
        dm = new DisplayMetrics();
        //返回当前资源对象的DispatchMetrics信息。
        dm = context.getApplicationContext().getResources().getDisplayMetrics();
        // 设置DensityDpi
        setDmDensityDpi(dm.densityDpi);
        // 密度因子
        scale = getDmDensityDpi() / 160;//等于 scale=dm.density;

        width = dm.widthPixels;
        height = dm.heightPixels;
    }

    public synchronized static DensityUtil getInstance(Context context) {
        if (instance == null) {
            instance = new DensityUtil(context.getApplicationContext());
        }
        return instance;
    }


    public float getDmDensityDpi() {
        return dmDensityDpi;
    }


    public void setDmDensityDpi(float dmDensityDpi) {
        this.dmDensityDpi = dmDensityDpi;
    }


    public int dip2px(float dipValue) {

        return (int) (dipValue * scale + 0.5f);

    }


    public int px2dip(float pxValue) {
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * get screen width
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     * get screen height
     *
     * @return
     */
    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return " dmDensityDpi:" + dmDensityDpi;
    }

    public static float dpConverToPx(Context context, float dp) {
        return context.getResources().getDisplayMetrics().density * dp;
    }

    public static float spConverToPx(Context context, float sp) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return sp * fontScale;
    }
}
