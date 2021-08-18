package com.example.myandroidkotlin.customview.sample3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Sample11GetFontSpacingView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello HenCoder";

    public Sample11GetFontSpacingView(Context context) {
        super(context);
    }

    public Sample11GetFontSpacingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample11GetFontSpacingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(60);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float spacing = paint.getFontSpacing();

        canvas.drawText(text, 50, 100, paint);

        canvas.drawText(text, 50, 100 + spacing, paint);

        canvas.drawText(text, 50, 100 + spacing * 2, paint);
    }
}
