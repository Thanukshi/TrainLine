package com.example.trainline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SeatBook extends AppCompatActivity {

    Spinner startStation, endStation, typeOfTrain;
    DatabaseReference reference;
    List<String> startStationName, endStationName, depTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_book);

        startStation = findViewById(R.id.sp1_ad);
        endStation = findViewById(R.id.sp2_ad);
        typeOfTrain = findViewById(R.id.sp4_ad);

        startStationName = new ArrayList<>();
        endStationName = new ArrayList<>();
        depTime = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference();
        reference.child("TrainSchedule").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot childSnapshot: snapshot.getChildren()){
                    startStationName.add(childSnapshot.child("startStation").getValue(String.class));
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(SeatBook.this, R.layout.style_spinner,startStationName);
                arrayAdapter.setDropDownViewResource(R.layout.style_spinner);
                startStation.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        reference = FirebaseDatabase.getInstance().getReference();
        reference.child("TrainSchedule").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot childSnapshot: snapshot.getChildren()){
                    endStationName.add(childSnapshot.child("endStation").getValue(String.class));
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(SeatBook.this, R.layout.style_spinner,endStationName);
                arrayAdapter.setDropDownViewResource(R.layout.style_spinner);
                endStation.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        reference = FirebaseDatabase.getInstance().getReference();
        reference.child("TrainSchedule").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot childSnapshot: snapshot.getChildren()){
                    depTime.add(childSnapshot.child("trainType").getValue(String.class));
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(SeatBook.this, R.layout.style_spinner,depTime);
                arrayAdapter.setDropDownViewResource(R.layout.style_spinner);
                typeOfTrain.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}