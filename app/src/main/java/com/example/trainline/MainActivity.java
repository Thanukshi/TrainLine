package com.example.trainline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.trainline.animation.ProgressBarAnimation;

public class MainActivity extends AppCompatActivity {

    //Declare Component in activity_main
    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.pBarWelcome);
        textView = findViewById(R.id.text1);

    }

    //Call the constructor of Progress
    public void ProgressBarAnimation(){
        ProgressBarAnimation barAnimation = new ProgressBarAnimation(this, progressBar, textView, 0f, 100f);
    }
}