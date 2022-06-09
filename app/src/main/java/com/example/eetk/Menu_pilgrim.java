package com.example.eetk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menu_pilgrim extends AppCompatActivity {

    Button button1;
    ImageButton button2;
    Button button3;
    ImageButton button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_pilgrim);

        button1 = findViewById(R.id.autoriz);
        button2 = findViewById(R.id.myrasp2);
        button3 = findViewById(R.id.myrasp1);
        button4 = findViewById(R.id.myrasp);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu_pilgrim.this, Authorisation.class);
                startActivity(i);
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu_pilgrim.this, Authorisation.class);
                startActivity(i);
                finish();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu_pilgrim.this, Prepods.class);
                startActivity(i);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu_pilgrim.this, Prepods.class);
                startActivity(i);
            }
        });
    }

}