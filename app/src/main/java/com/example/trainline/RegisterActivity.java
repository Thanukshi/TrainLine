package com.example.trainline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "AddToDataBase";

    private Button SignUp;
    private EditText UserName,Nic,Email,Password,RePassword;
    private RadioButton Passenger,Driver;
    private String userID,type;
    int maxId = 0;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        //declare the the values to variables.
        UserName = findViewById(R.id.userName);
        Nic  = findViewById(R.id.nic);
        Email  = findViewById(R.id.email);
        Password  = findViewById(R.id.passWord);
        RePassword  = findViewById(R.id.passWordComfirm);
        Passenger = findViewById(R.id.radioButton1);
        Driver  = findViewById(R.id.radioButton2);
        SignUp = findViewById(R.id.signIn);

//        //declare the database reference object.
//        //firebaseAuth = FirebaseAuth.getInstance();
            firebaseDatabase = FirebaseDatabase.getInstance();
            myRef = firebaseDatabase.getReference();
//        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
//       // userID = firebaseUser.getUid();

        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference("Registration");

        myRef.addValueEventListener(new ValueEventListener() {
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

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Log.d(TAG,"onClick: Submit pressed.");
                String userName = UserName.getText().toString().trim();
                String nic = Nic.getText().toString().trim();
                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();
                String passenger = Passenger.getText().toString().trim();
                String driver = Driver.getText().toString().trim();



                //Getting radio button values
                if(Driver.isChecked()){
                    type = driver;
                }
                if(Passenger.isChecked()){
                    type = passenger;
                }


                Log.d(TAG,"onClick: Attempting to submit to database: \n" +
                        "UserName" + userName + "\n"+
                        "Nic" + nic + "\n"+
                        "Email" + email + "\n"+
                        "Password" + password + "\n"+
                        "Type" + type + "\n"
                );

                if(!UserName.equals("") &&
                        !Nic.equals("") &&
                        !Email.equals("") &&
                        !Password.equals("") && (
                        !Driver.equals("") ||
                        !Passenger.equals(""))){

                    Users users = new Users(userName,nic,email,password,type);
                    myRef.child(String.valueOf(maxId + 1)).setValue(users);

                    toastMessage("Registration Completed");
//                    UserName.setText("");
//                    Nic.setText("");
//                    Email.setText("");
//                    Password.setText("");
//                    RePassword.setText("");
//                    Driver.setText("");
//                    Passenger.setText("");

                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);

                }else{
                    toastMessage("Fill Out All The Fields!!");
                }


            }
        });



    }


    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}