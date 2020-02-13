package com.example.gather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    Button buttonSubmitLogin, buttonLoginBack;
    EditText editTextLoginUsername, editTextLoginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonSubmitLogin = findViewById(R.id.buttonLoginSubmit);
        buttonLoginBack = findViewById(R.id.buttonLoginBack);

        editTextLoginPassword = findViewById(R.id.editTextLoginPassword);
        editTextLoginUsername = findViewById(R.id.editTextLoginUsername);

        buttonLoginBack.setOnClickListener(this);
        buttonSubmitLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.buttonLoginBack:
                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(mainIntent);

                break;

            case R.id.buttonLoginSubmit:

                Intent findEventIntent = new Intent(LoginActivity.this, FindEventsActivity.class);
                startActivity(findEventIntent);

                break;
        }
    }
}
