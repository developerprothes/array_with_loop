package com.prothes.arraywithloop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvDisplay;
    private AppCompatButton printBtn1,printBtn2, resetBtn;
    private String[] my_array1;
    private String[] my_array2 = {
            "JAVA","XML","SQL","PHP","HTML 5","CSS 3","BOOTSTRAP","WORDPRESS","C Programming","PYTHON","JAVA-SCRIPT","SEO"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
            WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
            layoutParams.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
            getWindow().setAttributes(layoutParams);
        }
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );
        setContentView(R.layout.activity_main);

        //=====================================================================
        tvDisplay = findViewById(R.id.tvDisplay);
        printBtn1 = findViewById(R.id.printBtn1);
        printBtn2 = findViewById(R.id.printBtn2);
        resetBtn = findViewById(R.id.resetBtn);
        my_array1 = getResources().getStringArray(R.array.my_array1);




        printBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i=0; i<my_array1.length; i++){
                    stringBuilder.append(my_array1[i]+"\n");
                }
                tvDisplay.setText(""+stringBuilder);
            }
        });


        printBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i=0; i<my_array2.length; i++){
                    stringBuilder.append(my_array2[i]+"\n");
                }
                tvDisplay.setText(""+stringBuilder);
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDisplay.setText(null);
            }
        });




    }
}