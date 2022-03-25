package com.example.eetk;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String PASSWORD_KEY = "PASSWORD_KEY";
    public static final String LOGIN_KEY = "LOGIN_KEY";
    Button enter;
    EditText login;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autoruzation);
        enter = findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Student_menu.class);
                login = findViewById(R.id.editTextLogin);
                password = findViewById(R.id.editTextPassword);
                String loginMessage = login.getText().toString();
                String passwordMessage = password.getText().toString();
                intent.putExtra(LOGIN_KEY, loginMessage);
                intent.putExtra(PASSWORD_KEY, passwordMessage);
                startActivity(intent);
            }
        });
    }
}