package com.example.gather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Declare objects
    Button buttonMainSignUp, buttonMainLogin;
    EditText editTextMainEmail, editTextMainPassword;
    private FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Users");



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
        String email = editTextMainEmail.getText().toString();
        String password = editTextMainPassword.getText().toString();

        switch (view.getId()) {

            case R.id.buttonMainLogin:

                //TODO add conditional checking to create a profile if user has not created one

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    checkProfileCreationStatus(myRef, user.getUid());
//                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(MainActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
//                                    updateUI(null);
                                }

                                // ...
                            }
                        });

//                if (true) {
//                    //TODO Refactor because it does not follow DRY principle
//
//
//                } else {
//                    Intent FindEventsIntent = new Intent(MainActivity.this, FindEventsActivity.class);
//                    startActivity(FindEventsIntent);
//
//                }
                //ADD MORE TO CARRY OVER USER INFO??


                break;

            case R.id.buttonMainSignUp:

                createAccount(email,password);


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

                            //Create new user in database with ID for referencing

                            //Separate into another function?

                            setNestedProperty(myRef,
                                    mAuth.getCurrentUser().getUid(),
                                    "userID",
                                    mAuth.getCurrentUser().getUid());

                            setNestedProperty(myRef,
                                    mAuth.getCurrentUser().getUid(),
                                    "completeProfile",
                                    false);


                            //After adding the user to database, go to create the user profile
                            Intent createProfileIntent = new Intent(MainActivity.this, CreateProfileActivity.class);
                            startActivity(createProfileIntent);

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

    public void setNestedProperty(DatabaseReference reference, String nestedKey, String userProperty, Object value){

        reference.child(nestedKey).child(userProperty).setValue(value);

    }

    public void checkProfileCreationStatus(DatabaseReference reference, String userId){

        //Checks the status of the user profile. If the user profile is created, goes to home, else go to create profile
        reference.child(userId).child("completeProfile").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!Boolean.parseBoolean(dataSnapshot.getValue().toString())){
                    Intent createProfileIntent = new Intent(MainActivity.this, CreateProfileActivity.class);
                    startActivity(createProfileIntent);

                } else {
                    Intent FindEventsIntent = new Intent(MainActivity.this, FindEventsActivity.class);
                    startActivity(FindEventsIntent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}
