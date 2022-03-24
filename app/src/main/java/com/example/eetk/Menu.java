package com.example.eetk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Menu extends AppCompatActivity {
    TextView textLogin;
    TextView textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Bundle arguments = getIntent().getExtras();
        String login = arguments.get(MainActivity.LOGIN_KEY).toString();
        String password = arguments.get(MainActivity.PASSWORD_KEY).toString();

        textLogin = findViewById(R.id.textLogin);
        textPassword = findViewById(R.id.textPassword);
        textLogin.setText(login);
        textPassword.setText(password);
    }
}