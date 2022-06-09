package com.example.eetk;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CreateAcc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_acc);
        TextView tv = (TextView) findViewById(R.id.sing_in);
        SpannableString content = new SpannableString("Войти");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        tv.setText(content);
    }
    public void sing_in(View v)
    {
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
