package com.example.gather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gather.Event;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateEventActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextEventNameInput, editTextEventSizeInput, editTextEventLocationInput,
             editTextEventTimeInput,editTextEventDateInput, editTextEventCostInput,
             editTextEventDescriptionInput;
    Button createEventBackButton, createEventCreateButton, createEventAddImageButton;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference eventReference = database.getReference("Events");
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        editTextEventNameInput = findViewById(R.id.editTextEventNameInput);
        editTextEventSizeInput = findViewById(R.id.editTextEventSizeInput);
        editTextEventLocationInput = findViewById(R.id.editTextEventLocationInput);
        editTextEventTimeInput = findViewById(R.id.editTextEventTimeInput);
        editTextEventDateInput = findViewById(R.id.editTextEventDateInput);
        editTextEventCostInput = findViewById(R.id.editTextEventCostInput);
        editTextEventDescriptionInput = findViewById(R.id.editTextEventDescriptionInput);

        createEventBackButton = findViewById(R.id.createEventBackButton);
        createEventCreateButton = findViewById(R.id.createEventCreateButton);
        createEventAddImageButton = findViewById(R.id.createEventAddImageButton);

        createEventBackButton.setOnClickListener(this);
        createEventCreateButton.setOnClickListener(this);
        createEventAddImageButton.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();


        Event testEvent = new Event.EventBuilder().eventName("lit").description("it's lit").build();
        DatabaseReference newEventReference = eventReference.push();
        newEventReference.setValue(testEvent);
        Toast.makeText(this, newEventReference.getKey(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, mAuth.getUid(), Toast.LENGTH_SHORT).show(); // TODO Add foreign key of created event to user event list
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.createEventBackButton:

                Intent backIntent = new Intent(CreateEventActivity.this, FindEventsActivity.class);
                startActivity(backIntent);

                break;

            case R.id.createEventAddImageButton:

                //TODO implement image addition to event/add to firebase storage

                break;

            case R.id.createEventCreateButton:

                //TODO Build events based off of input

                break;
        }
    }
}
