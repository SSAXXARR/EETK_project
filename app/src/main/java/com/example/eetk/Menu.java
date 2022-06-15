package com.example.eetk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {
    TextView tv;
    Button button1;
    ImageButton button2;
    Button button3;
    ImageButton button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        button2 = findViewById(R.id.myrasp);
        button1 = findViewById(R.id.myrasp1);
        button3 = findViewById(R.id.rasp_col);
        button4 = findViewById(R.id.myrasp2);
        tv = findViewById(R.id.textView);
        tv.setText(getIntent().getStringExtra("name"));

        Intent intent = new Intent();
        Bundle b = new Bundle();
        String txtName = getIntent().getStringExtra("name");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setClass(Menu.this, Schedule.class);
                if(txtName.equalsIgnoreCase("Анастасия Сергеевна Аминова")){
                    b.putString("classID","1");
                    intent.putExtras(b);
                    intent.putExtra("name", txtName);
                    startActivity(intent);
                }else if(txtName.equalsIgnoreCase("Анастасия Александровна Саитова")){
                    b.putString("classID","2");
                    intent.putExtras(b);
                    intent.putExtra("name", txtName);
                    startActivity(intent);
                }else if(txtName.equalsIgnoreCase("Ксения Андреевна Попкова")){
                    b.putString("classID","3");
                    intent.putExtras(b);
                    intent.putExtra("name", txtName);
                    startActivity(intent);
                }else if(txtName.equalsIgnoreCase("Екатерина Геннадьевна Серкова")){
                    b.putString("classID","4");
                    intent.putExtras(b);
                    intent.putExtra("name", txtName);
                    startActivity(intent);
                }else if(txtName.equalsIgnoreCase("Марина Алфеевна Кореганова")){
                    b.putString("classID","5");
                    intent.putExtras(b);
                    intent.putExtra("name", txtName);
                    startActivity(intent);
                }else{
                    Toast.makeText(Menu.this, "Вашу заявку еще не рассмотрели", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setClass(Menu.this, Schedule.class);
                if(txtName.equalsIgnoreCase("Анастасия Сергеевна Аминова")){
                    b.putString("classID","1");
                    intent.putExtras(b);
                    intent.putExtra("name", txtName);
                    startActivity(intent);
                }else if(txtName.equalsIgnoreCase("Анастасия Александровна Саитова")){
                    b.putString("classID","2");
                    intent.putExtras(b);
                    intent.putExtra("name", txtName);
                    startActivity(intent);
                }else if(txtName.equalsIgnoreCase("Ксения Андреевна Попкова")){
                    b.putString("classID","3");
                    intent.putExtras(b);
                    intent.putExtra("name", txtName);
                    startActivity(intent);
                }else if(txtName.equalsIgnoreCase("Екатерина Геннадьевна Серкова")){
                    b.putString("classID","4");
                    intent.putExtras(b);
                    intent.putExtra("name", txtName);
                    startActivity(intent);
                }else if(txtName.equalsIgnoreCase("Марина Алфеевна Кореганова")){
                    b.putString("classID","5");
                    intent.putExtras(b);
                    intent.putExtra("name", txtName);
                    startActivity(intent);
                }else{
                    Toast.makeText(Menu.this, "Вашу заявку еще не рассмотрели", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, Prepods.class);
                startActivity(i);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, Prepods.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(Menu.this, Authorisation.class);
        startActivity(intent);
        finish();
        return true;
    }
}