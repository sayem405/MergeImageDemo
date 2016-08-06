package com.sayem.android.mergeimagedemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by sayem on 8/5/2016.
 */
public class ImageBaseView extends ImageView {

    private Bitmap mainBitmap;
    private Bitmap emoBitmap;


    public ImageBaseView(Context context) {
        super(context);
    }

    public ImageBaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageBaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ImageBaseView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (emoBitmap != null) {

            canvas.drawBitmap(emoBitmap, 100f, 100f, new Paint(Paint.ANTI_ALIAS_FLAG));
        }
    }


    public void setEmoBitmap(Bitmap emoBitmap) {
        this.emoBitmap = emoBitmap;
        setWillNotDraw(false);
    }

    public void setMainBitmap(Bitmap mainBitmap) {
        this.mainBitmap = mainBitmap;
        setWillNotDraw(false);
    }
}
