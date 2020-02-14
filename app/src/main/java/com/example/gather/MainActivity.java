package com.example.gather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Declare objects
    Button buttonMainSignUp, buttonMainLogin;
    EditText editTextMainEmail, editTextMainPassword;
    private FirebaseAuth mAuth;

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

        editTextMainEmail = findViewById(R.id.editTextMainEmail);
        editTextMainPassword = findViewById(R.id.editTextMainPassword);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

    }


    //Implements onclick METHOD to handle button pressing
    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.buttonMainLogin:

                //ADD MORE TO CARRY OVER USER INFO??
                Intent FindEventsIntent = new Intent(MainActivity.this, FindEventsActivity.class);
                startActivity(FindEventsIntent);

                break;

            case R.id.buttonMainSignUp:
                String email = editTextMainEmail.getText().toString();
                String password = editTextMainPassword.getText().toString();

                createAccount(email,password);

                Intent createProfileIntent = new Intent(MainActivity.this, CreateProfileActivity.class);
                startActivity(createProfileIntent);


                break;
        }
    }

    public void createAccount(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // ...
                    }
                });
    }
}
