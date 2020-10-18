package com.example.trainline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener AuthListener;
    private DatabaseReference myRef;

    //UI Refs
    private Button SignUp,SignIn,GuestLogin;
    private EditText UserName,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Declare buttons and edit texts
        UserName = findViewById(R.id.userName);
        Password  = findViewById(R.id.passWord);
        SignUp = findViewById(R.id.signUp);
        SignIn = findViewById(R.id.signIn);
        GuestLogin = findViewById(R.id.guestBtn);

        firebaseAuth = FirebaseAuth.getInstance();

//        AuthListener = new FirebaseAuth.AuthStateListener(){
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
//                if(firebaseUser != null){
//                    Log.d(TAG,"onAuthStateChanged:signed_in:"+ firebaseUser.getUid());
//                    toastMessage("Successfully signed in with: " + firebaseUser.getEmail());
//                }else{
//                    //User is signed out
//                    Log.d(TAG, "onAuthStateChanged:signed_out");
//                    toastMessage("signed out.");
//                }
//                }
//            };

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = UserName.getText().toString();
                String password = Password.getText().toString();

                if(!userName.equals("") && !password.equals("")){
                    firebaseAuth.signInWithEmailAndPassword(userName,password);
                }else{
                    toastMessage("You didn't fill in all the fields.");
                }
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
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