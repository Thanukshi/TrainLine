package com.example.trainline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trainline.modal.TrainScheduleModal;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TrainSchedule extends AppCompatActivity {

    //Declare Firebase Instance
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    //Declare Component of layout
    EditText startStation, endStation, departureTime, destination, price, typeOfTrain;
    Button addBtn;
    int maxId = 0;

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
        addBtn = findViewById(R.id.add_ts);

        //Set ID
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("TrainSchedule");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    maxId = (int) snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //Save data to the firebase
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String startStations = startStation.getText().toString().trim();
                String endStations = endStation.getText().toString().trim();
                String depTime = departureTime.getText().toString().trim();
                Float destinations = Float.parseFloat(destination.getText().toString());
                Float ticketPrice = Float.parseFloat(price.getText().toString());
                String destinati = destination.getText().toString().trim();
                String ticketPri = price.getText().toString().trim();
                String trainType = typeOfTrain.getText().toString().trim();

                if(TextUtils.isEmpty(startStations)){
                    startStation.setError("Start Station Name is Required.");
                    return;
                }
                if(TextUtils.isEmpty(endStations)){
                    endStation.setError("Start Station Name is Required.");
                    return;
                }
                if(TextUtils.isEmpty(depTime)){
                    departureTime.setError("Departure is Required.");
                    return;
                }
                if(TextUtils.isEmpty(destinati)){
                    destination.setError("Distance is Required.");
                    return;
                }
                if(TextUtils.isEmpty(ticketPri)){
                    price.setError("Ticket Price is Required.");
                    return;
                }
                if(TextUtils.isEmpty(trainType)){
                    typeOfTrain.setError("Train Type is Required.");
                    return;
                }

                TrainScheduleModal trainScheduleModal = new TrainScheduleModal(startStations,endStations,depTime,destinations,ticketPrice,trainType);
                reference.child(String.valueOf(maxId + 1)).setValue(trainScheduleModal);
                Toast.makeText(getApplicationContext(),"New Train Schedule is added Successfully..",Toast.LENGTH_SHORT).show();

            }
        });


    }
}