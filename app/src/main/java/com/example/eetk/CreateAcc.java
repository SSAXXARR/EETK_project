package com.example.eetk;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateAcc extends AppCompatActivity {
    EditText name,email,password,password2;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_acc);
        TextView tv = (TextView) findViewById(R.id.sing_in);
        SpannableString content = new SpannableString("Войти");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        tv.setText(content);
        name = findViewById(R.id.editTextName);
        email = findViewById(R.id.editTextLogin);
        password = findViewById(R.id.editTextPassword);
        password2 = findViewById(R.id.editTextPassword2);

        dbHelper = new DBHelper(this);
    }
    public void zaregButton(View v){
        String name1 = name.getText().toString();
        String email1 = email.getText().toString();
        String password1 = password.getText().toString();
        String password3 = password2.getText().toString();
        if(name1.equals("")||email1.equals("")||password1.equals("") || password3.equals(""))
            Toast.makeText(this, "Одно из полей не заполнено", Toast.LENGTH_SHORT).show();
        else{
            if(password1.equals(password3)){
                Boolean checkuser = dbHelper.checkusername(name1);
                if(checkuser==false){
                    Boolean insert = dbHelper.insertData(name1, password1);
                    if(insert == true){
                        Toast.makeText(this, "Регистрация удалась", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(CreateAcc.this, Authorisation.class);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(this, "Регистрация провалена", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(this, "Пользователь существует или вы ошиблись, проверьте написание или зарегистрируйтесь",
                            Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Пароль не совпадает", Toast.LENGTH_SHORT).show();
            }
        } }

    public void sing_in(View v){
        Intent i = new Intent(CreateAcc.this, Authorisation.class);
        startActivity(i);
        finish();
    }

    public void skip2(View v)
    {
        Intent i = new Intent(CreateAcc.this, Menu_pilgrim.class);
        startActivity(i);
        finish();
    }
}
