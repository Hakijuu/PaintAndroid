package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity{

    private static int sbValue;
    private static int color;

    Button buttonBLACK, buttonWHITE, buttonGRAY, buttonYELLOW, buttonORANGE, buttonRED, buttonPINK, buttonPURPLE, buttonBLUE, buttonGREEN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar sb = findViewById(R.id.sizeBar);
        sbValue = sb.getProgress();
        color = Color.BLACK;
        buttonBLACK = findViewById(R.id.buttonBLACK);
        buttonWHITE = findViewById(R.id.buttonWHITE);
        buttonGRAY = findViewById(R.id.buttonGRAY);
        buttonYELLOW = findViewById(R.id.buttonYELLOW);
        buttonORANGE = findViewById(R.id.buttonORANGE);
        buttonRED = findViewById(R.id.buttonRED);
        buttonPINK = findViewById(R.id.buttonPINK);
        buttonPURPLE = findViewById(R.id.buttonPURPLE);
        buttonBLUE = findViewById(R.id.buttonBLUE);
        buttonGREEN = findViewById(R.id.buttonGREEN);

        buttonBLACK.setOnClickListener(v -> color = Color.BLACK);

        buttonWHITE.setOnClickListener(v -> color = Color.WHITE);

        buttonGRAY.setOnClickListener(v -> color = Color.GRAY);

        buttonYELLOW.setOnClickListener(v -> color = Color.YELLOW);

        buttonORANGE.setOnClickListener(v -> color = Color.parseColor("#FF9111"));

        buttonRED.setOnClickListener(v -> color = Color.RED);

        buttonPINK.setOnClickListener(v -> color = Color.parseColor("#FF00FF"));

        buttonPURPLE.setOnClickListener(v -> color = Color.parseColor("#800080"));

        buttonBLUE.setOnClickListener(v -> color = Color.BLUE);

        buttonGREEN.setOnClickListener(v -> color = Color.GREEN);


        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sbValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            });
        }
    static int getsbValue(){return sbValue;}
    static int getColor(){return color; }

}