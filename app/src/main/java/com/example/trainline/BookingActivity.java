package com.example.trainline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BookingActivity extends AppCompatActivity {

    Button bookSeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        bookSeat = findViewById(R.id.booking_b);

        bookSeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent booking = new Intent(BookingActivity.this, SeatBook.class);
                startActivity(booking);
            }
        });
    }
}