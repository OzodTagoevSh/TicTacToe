package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean imageType = true;
    public void click(View view) {
        ImageView counter = (ImageView) view;
        counter.animate().alpha(1).setDuration(1000);
        if(imageType) {
            counter.setImageResource(R.drawable.o);
            imageType = false;
        } else {
            counter.setImageResource(R.drawable.x);
            imageType = true;
        }
    }

    public void cross(View view) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}