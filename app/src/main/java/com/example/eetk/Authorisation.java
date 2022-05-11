package com.example.eetk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Authorisation extends AppCompatActivity {
    public static final String PASSWORD_KEY = "PASSWORD_KEY";
    public static final String LOGIN_KEY = "LOGIN_KEY";
    Button enter, register;
    EditText login, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autoruzation);
        enter = findViewById(R.id.enter);
        register = findViewById(R.id.bntReg);
    }
}