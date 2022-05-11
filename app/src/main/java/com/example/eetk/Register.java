package com.example.eetk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText mLogin, mPassword, mRePassword;
    Button btnRegister;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        mLogin = findViewById(R.id.editTextLogin);
        mPassword = findViewById(R.id.editTextPassword);
        mRePassword = findViewById(R.id.editTextPassword2);
        btnRegister = findViewById(R.id.btnRegistration);
        spinner = findViewById(R.id.spinner);
    }
}