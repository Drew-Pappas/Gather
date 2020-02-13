package com.example.gather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Declare objects
    Button buttonMainSignUp, buttonMainLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect objects with UI elements
        buttonMainLogin = findViewById(R.id.buttonMainLogin);
        buttonMainSignUp = findViewById(R.id.buttonMainSignUp);

        //Set listeners to be able to handle clicks
        buttonMainSignUp.setOnClickListener(this);
        buttonMainLogin.setOnClickListener(this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
    }


    //Implements onclick METHOD to handle button pressing
    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.buttonMainLogin:
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginIntent);

                break;

            case R.id.buttonMainSignUp:

                Intent signUpIntent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(signUpIntent);

                break;
        }
    }
}
