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
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        mLogin = findViewById(R.id.editTextLogin);
        mPassword = findViewById(R.id.editTextPassword);
        mRePassword = findViewById(R.id.editTextPassword2);
        btnRegister = findViewById(R.id.btnRegistration);
        spinner = findViewById(R.id.spinner);
        DB = new DBHelper(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mLogin.getText().toString();
                String password = mPassword.getText().toString();
                String rePassword = mRePassword.getText().toString();

                if(user.equals("") || password.equals("") || rePassword.equals("")){
                    Toast.makeText(Register.this, "Одно из полей пустое", Toast.LENGTH_SHORT).show();
                } else{
                    // if passwords is matched
                    if(password.equals(rePassword)){
                        //проверка существует ли уже этот пользователь.
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser == false){
                            //добавляем в базу пользователя.
                            Boolean insert = DB.insertData(user, password);
                            //если запись была добавлена
                            if(insert == true){
                                Toast.makeText(Register.this, "Регистрация завершена!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Authorisation.class);
                                startActivity(intent);
                                //чтобы при нажатии back не открылась опять.
                                finish();
                            }else{
                                Toast.makeText(Register.this, "Регистрация не удалась", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(Register.this, "Такой пользователь уже существует", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(Register.this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}