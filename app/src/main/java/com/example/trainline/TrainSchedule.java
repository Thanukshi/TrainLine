package com.example.trainline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class TrainSchedule extends AppCompatActivity {

    EditText startStation, endStation, departureTime, destination, price, typeOfTrain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_schedule);

        startStation = findViewById(R.id.et1_ad);
        endStation = findViewById(R.id.et2_ad);
        departureTime = findViewById(R.id.et3_ad);
        destination = findViewById(R.id.et4_ad);
        price = findViewById(R.id.et5_ad);
        typeOfTrain = findViewById(R.id.et6_ad);
    }
}