package com.example.gather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.example.gather.User;
import com.example.gather.Event;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateProfileActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonCreateProfileBack,
            buttonCreateProfileSubmit;

    EditText editTextCreateProfileFirstName,
            editTextCreateProfileLastName,
            editTextCreateProfileAge,
            editTextCreateProfileBio;


    ImageView imageViewCreateProfileProfilePicture;

    private FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        buttonCreateProfileBack = findViewById(R.id.buttonCreateProfileBack);
        buttonCreateProfileSubmit = findViewById(R.id.buttonCreateProfileSubmit);

        buttonCreateProfileBack.setOnClickListener(this);
        buttonCreateProfileSubmit.setOnClickListener(this);

        editTextCreateProfileFirstName = findViewById(R.id.editTextCreateProfileFirstName);
        editTextCreateProfileLastName = findViewById(R.id.editTextCreateProfileLastName);
        editTextCreateProfileAge = findViewById(R.id.editTextCreateProfileAge);
        editTextCreateProfileBio = findViewById(R.id.editTextCreateProfileBio);




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.buttonCreateProfileBack:
                Intent mainIntent = new Intent(CreateProfileActivity.this, MainActivity.class);
                startActivity(mainIntent);

                break;

            case R.id.buttonCreateProfileSubmit:

                Intent findEventsIntent = new Intent(CreateProfileActivity.this, FindEventsActivity.class);
                startActivity(findEventsIntent);

                break;
        }
    }


    private boolean validateForm() {
        boolean valid = true;

        String firstName = editTextCreateProfileFirstName.getText().toString();
        if (TextUtils.isEmpty(firstName)) {
            editTextCreateProfileFirstName.setError("Required.");
            valid = false;
        } else {
            editTextCreateProfileFirstName.setError(null);
        }

        String lastName = editTextCreateProfileLastName.getText().toString();
        if (TextUtils.isEmpty(firstName)) {
            editTextCreateProfileLastName.setError("Required.");
            valid = false;
        } else {
            editTextCreateProfileLastName.setError(null);
        }

        String bio = editTextCreateProfileBio.getText().toString();
        if (TextUtils.isEmpty(firstName)) {
            editTextCreateProfileBio.setError("Required.");
            valid = false;
        } else {
            editTextCreateProfileBio.setError(null);
        }

        int age = Integer.parseInt(editTextCreateProfileAge.getText().toString());
        if (TextUtils.isEmpty(firstName)) {
            editTextCreateProfileAge.setError("Required.");
            valid = false;
        } else {
            editTextCreateProfileAge.setError(null);
        }


        return valid;
    }
}
