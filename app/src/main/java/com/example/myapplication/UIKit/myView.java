package com.example.myapplication.UIKit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.io.InputStream;

/**
 * Created by 59772 on 2017/2/4.
 */

public class myView extends RelativeLayout {
    private String mtext;
    private int msrc ;

    public myView(Context context) {
        super(context);

    }

    public myView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        int textId = attrs.getAttributeResourceValue(null, "Text",0);
        int srcId = attrs.getAttributeResourceValue(null, "Src", 0);
        mtext = context.getResources().getText(textId).toString();
        msrc = srcId;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        InputStream is = getResources().openRawResource(msrc);
        Bitmap mBitmap = BitmapFactory.decodeStream(is);
        int bh = mBitmap.getHeight();
        int bw = mBitmap.getWidth();
        canvas.drawBitmap(mBitmap, 0,0, paint);
        canvas.drawCircle(15, 15, 15, paint);
        canvas.drawText(mtext, bw/2, 30, paint);
    }
}
