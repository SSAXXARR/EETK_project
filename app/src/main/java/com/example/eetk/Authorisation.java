package com.example.eetk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Authorisation extends AppCompatActivity {
    Button enter;
    EditText login, password;
    DBHelper DB;
    SharedPreferences mSettings;
    static SharedPreferences.Editor editor;
    String NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autoruzation);

        TextView tv = (TextView) findViewById(R.id.zareg);
        SpannableString content = new SpannableString("Зарегистрироваться");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        tv.setText(content);

        login = (EditText) findViewById(R.id.editTextLogin);
        password = (EditText) findViewById(R.id.editTextPassword);
        enter = findViewById(R.id.enter);
        DB = new DBHelper(this);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = login.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(Authorisation.this, "Одно из полей не заполнено", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass == true){
                        Intent intent  = new Intent(getApplicationContext(), Menu.class);
                        intent.putExtra("name", user);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Authorisation.this, "Данные неверны", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public void clikZareg(View v)
    {
        Intent i = new Intent(Authorisation.this, CreateAcc.class);
        startActivity(i);
        finish();
    }
    public void skip(View v)
    {
        Intent i = new Intent(Authorisation.this, Menu_pilgrim.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /*public static final String PASSWORD_KEY = "PASSWORD_KEY";
    public static final String LOGIN_KEY = "LOGIN_KEY";
    Button enter, register;
    EditText login, password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autoruzation);
        findViewById(R.id.enter).setOnClickListener(this);
        //findViewById(R.id.bntReg).setOnClickListener(this);
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
                                Intent i = new Intent(Authorisation.this, Prepods.class);
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
    }*/
}