package com.example.eetk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Authorisation extends AppCompatActivity implements View.OnClickListener{
    public static final String PASSWORD_KEY = "PASSWORD_KEY";
    public static final String LOGIN_KEY = "LOGIN_KEY";
    Button enter, register;
    EditText login, password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autoruzation);
        findViewById(R.id.enter).setOnClickListener(this);
        findViewById(R.id.bntReg).setOnClickListener(this);
        login = (EditText) findViewById(R.id.editTextLogin);
        password = (EditText) findViewById(R.id.editTextPassword);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    @Override
    public void onClick(View view) {
        //если нажата кнопка войти
        if(view.getId() == R.id.enter){
            //если одно из полей не заполнено
            if(password.getText().toString().equals("") && login.getText().toString().equals("")) {
                Toast.makeText(this, "одно из полей не заполнено", Toast.LENGTH_SHORT).show();
            }else{
                singIn(login.getText().toString(), password.getText().toString());
            }
        }
        // если нажата кнопка зарегистрироваться
        else if(view.getId() == R.id.bntReg){
            //если одно из полей не заполнено
            if(password.getText().toString().equals("") && login.getText().toString().equals("")) {
                Toast.makeText(this, "одно из полей не заполнено", Toast.LENGTH_SHORT).show();
            }else{
                registration(login.getText().toString(), password.getText().toString());
            }
        }
    }

    // метод авторизации
    public void singIn(String email, String password){
        //firebase объект, мы входим с исп почты и пароля
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //если таск завершается успешно, то
                            if (task.isSuccessful()) {
                                Toast.makeText(Authorisation.this, "Авторизация успешна", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Authorisation.this, Admin_menu.class);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(Authorisation.this, "Авторизация не удалась", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

    }

    //метод регистрации
    public void registration(String email, String password){
        if(email == "" && password == "") {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                        //если регистрация удалась
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Authorisation.this, "Регистрация удалась!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Authorisation.this, "Не удалось зарегистрироваться", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }else{
            Toast.makeText(this, "одно из полей не заполнено", Toast.LENGTH_SHORT).show();
        }
    }
}