package com.example.houandli.dotpic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class penView extends View {
    //Define where to show the image
    public int bitmapX;
    public int bitmapY;

    public int w = 128;
    public int h = 128;

    public penView(Context context) {
        super(context);
        //Where to start
        bitmapX = 8;
        bitmapY = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_pen);
        Rect src = new Rect(0, 0, bitmap.getWidth()-1, bitmap.getHeight()-1);  //Original Image Rect
        Rect dst = new Rect(bitmapX, bitmapY, bitmapX + w - 1, bitmapY + h - 1);  //Target Rect

        //draw the pic
        canvas.drawBitmap(bitmap, src, dst, paint);
        if(bitmap.isRecycled())
        {
            bitmap.recycle();
        }
    }

}
