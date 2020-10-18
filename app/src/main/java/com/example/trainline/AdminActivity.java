package com.example.trainline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {

    Button trainSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        trainSchedule = findViewById(R.id.tSchedule);

        trainSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scheduleTrain = new Intent(AdminActivity.this, TrainSchedule.class);
                startActivity(scheduleTrain);
            }
        });
    }
}