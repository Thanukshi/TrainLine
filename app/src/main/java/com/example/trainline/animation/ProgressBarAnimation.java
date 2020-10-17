package com.example.trainline.animation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarAnimation extends Animation {

    //Declare the variable in main xml layout
    private Context context;
    private ProgressBar progressBar;
    private TextView textView;
    private float fromTime;
    private float toTime;

    //declare the constructor bar function
    public ProgressBarAnimation(Context context, AttributeSet attrs, Context context1, ProgressBar progressBar, TextView textView, float fromTime, float toTime) {
        this.context = context;
        this.progressBar = progressBar;
        this.textView = textView;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);

        float value = fromTime + (toTime - fromTime) * interpolatedTime;
        progressBar.setProgress((int)value);
        textView.setText((int)value + " %");
    }
}
