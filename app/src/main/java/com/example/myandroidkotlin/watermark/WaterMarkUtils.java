package com.example.myandroidkotlin.watermark;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * @author wanjing
 * @date 2018/9/11
 * <p>
 * 水印工具类(河南省厅特制)
 */
public class WaterMarkUtils {

    /**
     * 绘制水印
     */
    public static void drawWaterMark(final Activity activity, final String text) {
        DisplayMetrics dm = activity.getResources().getDisplayMetrics();
        final int screenWidth = dm.widthPixels;
        final int screenHeight = dm.heightPixels;
        ImageView ivWater = new ImageView(activity);
        ViewGroup rootView = activity.findViewById(android.R.id.content);
        ivWater.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        rootView.addView(ivWater);

        new Handler().postDelayed(() -> {
            Bitmap bitmap = Bitmap.createBitmap(screenWidth+ivWater.getWidth(), screenHeight+ivWater.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawTextToBitmap(activity, canvas, screenWidth+ivWater.getWidth(), screenHeight+ivWater.getHeight(), text);
            ivWater.setImageBitmap(bitmap);
        }, 100);
    }

    private static void drawTextToBitmap(Activity activity, Canvas canvas, int width, int height, String text) {
        String[] strings = text.split("-");
        if (strings.length < 3) {
            return;
        }
        String text1 = strings[0];
        String text2 = strings[1];
        String text3 = strings[2];

        //要添加的文字
        //新建画笔，默认style为实心
        Paint paint = new Paint();
        //设置颜色，颜色可用Color.parseColor("#808080")代替
        paint.setColor(Color.parseColor("#808080"));
        //设置透明度
        paint.setAlpha(80);
        //抗锯齿
        paint.setAntiAlias(true);
        //画笔粗细大小
        paint.setTextSize((float) DensityUtil.getInstance(activity).dip2px(18));
        //保存当前画布状态
        canvas.save();
        //画布旋转-30度
        canvas.rotate(-30);
        //获取要添加文字的宽度
        String maxLengthText = (text1.length() > text2.length() ? text1 : text2).length() > text3.length()
                ? (text1.length() > text2.length() ? text1 : text2) : text3;
        float textWidth = paint.measureText(maxLengthText) + 20;
        //行循环，从高度为0开始，向下每隔80dp开始绘制文字
        for (int positionY = - DensityUtil.getInstance(activity).dip2px(80);
             positionY <= height; positionY += DensityUtil.getInstance(activity).dip2px(140)) {
            //设置每行文字开始绘制的位置,0.58是根据角度算出tan30°,后面的(index++ % 2) * textWidth是为了展示效果交错绘制
//            float fromX = -0.58f * height + (index++ % 2) * textWidth;
//            float fromX = -0.58f * height +  textWidth;
            float fromX = - DensityUtil.getInstance(activity).dip2px(500);
            //列循环，从每行的开始位置开始，向右每隔2倍宽度的距离开始绘制（文字间距1倍宽度）
            for (float positionX = fromX; positionX < width; positionX += textWidth + DensityUtil.getInstance(activity).dip2px(50)) {
                //绘制文字
                canvas.drawText(text1, positionX, positionY, paint);
                canvas.drawText(text2, positionX, positionY + (float) DensityUtil.getInstance(activity).dip2px(18), paint);
                canvas.drawText(text3, positionX, positionY + 2 * (float) DensityUtil.getInstance(activity).dip2px(18), paint);
            }
        }
        //恢复画布状态
        canvas.restore();
    }
}
