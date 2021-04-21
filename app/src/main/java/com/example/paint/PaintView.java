package com.example.paint;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import static com.example.paint.MainActivity.getsbValue;

public class PaintView extends SurfaceView implements SurfaceHolder.Callback{
    List<RectF> ovalsMap;
    Paint paint;
    int sbValue;

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ovalsMap = new ArrayList<>();
        paint = new Paint();
        sbValue= 15;
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }

    @SuppressLint("ClickableViewAccessibility")
    public boolean onTouchEvent(MotionEvent event) {
        sbValue = getsbValue();
        RectF oval = new RectF(event.getX()-sbValue,event.getY()-sbValue,event.getX()+sbValue,event.getY()+sbValue);
        ovalsMap.add(oval);
        invalidate(); //Wymagane jest przemalowanie ekranu -> onDraw
        return true;
    }

    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.RED);

        for (RectF oval : ovalsMap) {
            canvas.drawOval(oval, paint);
        }
    }


}
