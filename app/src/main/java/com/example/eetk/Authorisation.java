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
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autoruzation);
        enter = findViewById(R.id.enter);
        register = findViewById(R.id.bntReg);
        DB = new DBHelper(this);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Authorisation.this, Student_menu.class);
                login = findViewById(R.id.editTextLogin);
                password = findViewById(R.id.editTextPassword);

                String mLogin = login.getText().toString();
                String mPassword = password.getText().toString();
                if(mLogin.equals("") || mPassword.equals("")){
                    Toast.makeText(Authorisation.this, "Одно из полей незаполнено", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkuserpass = DB.checkusernamepassword(mLogin, mPassword);
                    //пользователь существует и пароль верен.
                    if(checkuserpass == true){
                        intent.putExtra(LOGIN_KEY, mLogin);
                        intent.putExtra(PASSWORD_KEY, mPassword);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(Authorisation.this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
    }
}