package com.example.gather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonSignUpBack, buttonSignUpSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        buttonSignUpBack = findViewById(R.id.buttonSignUpBack);
        buttonSignUpSubmit = findViewById(R.id.buttonSignUpSubmit);

        buttonSignUpBack.setOnClickListener(this);
        buttonSignUpSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.buttonSignUpBack:
                Intent mainIntent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(mainIntent);

                break;

            case R.id.buttonSignUpSubmit:

                Intent loginIntent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(loginIntent);

                break;
        }
    }
}
