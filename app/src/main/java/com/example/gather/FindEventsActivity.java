package com.example.gather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gather.Event;
import com.example.gather.User;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.example.gather.EventAdapter;

public class FindEventsActivity extends AppCompatActivity implements View.OnClickListener {


    Button buttonCreateEvent;
    FrameLayout testFrame;

    private CreateEventFragment createEventFragment;

    private FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Users");

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_events);

        testFrame = findViewById(R.id.test_frame);

        buttonCreateEvent = findViewById(R.id.buttonCreateEvent);
        buttonCreateEvent.setOnClickListener(this);

        createEventFragment = new CreateEventFragment();

        recyclerView = (RecyclerView) findViewById(R.id.findEventsRecyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter
//        mAdapter = new EventAdapter(myDataset); // TODO Write function to pull in list of events from database
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view) {

        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
        setFragment(createEventFragment);
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.test_frame, fragment); //TODO replace with UI to hold the fragment interface
        fragmentTransaction.commit();
    }
}
