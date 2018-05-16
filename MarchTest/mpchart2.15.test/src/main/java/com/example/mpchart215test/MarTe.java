package com.example.mpchart215test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class MarTe extends TextView {
    public MarTe(Context context) {
        super(context);
    }

    public MarTe(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MarTe(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
