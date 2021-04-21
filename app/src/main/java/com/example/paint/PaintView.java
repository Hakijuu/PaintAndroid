package com.example.paint;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
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
import static com.example.paint.MainActivity.getColor;

public class PaintView extends SurfaceView implements SurfaceHolder.Callback{
    List<Oval> ovalsMap;
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
        Oval oval = new Oval(event.getX(), event.getY(), getColor(), getsbValue());
        ovalsMap.add(oval);
        invalidate(); //Wymagane jest przemalowanie ekranu -> onDraw
        return true;
    }

    protected void onDraw(Canvas canvas) {
        for (Oval oval : ovalsMap) {
            paint.setColor(oval.color);
            canvas.drawOval(oval.o, paint);
        }
    }

    private static class Oval {
        int color;
        RectF o;
        public Oval(float x, float y, int color, int size){
          o = new RectF(x-size,y-size,x+size,y+size);
          this.color = color;
      }
    }
}
