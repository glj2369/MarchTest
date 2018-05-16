package com.example.mpchart215test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

@SuppressLint("AppCompatCustomView")
public class Picture extends ImageView implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {
    private ScaleGestureDetector scaleGestureDetector;
    private Matrix matrix = new Matrix();
    private Boolean once = true;

    public Picture(Context context) {
        //super(context);
        this(context, null);
    }

    public Picture(Context context, @Nullable AttributeSet attrs) {
        //super(context, attrs);
        this(context, attrs, 0);

    }

    public Picture(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setScaleType(ScaleType.MATRIX);
        scaleGestureDetector = new ScaleGestureDetector(context, this);
        setOnTouchListener(this);

    }

    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        float factor = detector.getScaleFactor();
        matrix.postScale(factor, factor, getWidth() / 2, getHeight() / 2);
        setImageMatrix(matrix);

        return true;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return scaleGestureDetector.onTouchEvent(event);
    }

    @Override
    public void onGlobalLayout() {
        if (!once) {
            return;
        }
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        matrix.postTranslate(1.0f * (width - intrinsicWidth) / 2, 1.0f * (height - intrinsicHeight) / 2);
        matrix.postScale(1.0f, 1.0f, width / 2, height / 2);
        setImageMatrix(matrix);
        once = false;

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
}
