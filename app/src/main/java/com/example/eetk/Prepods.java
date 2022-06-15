package com.example.eetk;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Prepods extends AppCompatActivity {

    static final String EXTRA_STATION_RESULT = "EXTRA STATION RESULT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prepods);

        // получаем экземпляр элемента ListView
        ListView listView = findViewById(R.id.listView);

        String[] prepods_names = getResources().getStringArray(R.array.prepods_names);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.mytextview2,R.id.text_view_cat_name, prepods_names);

        listView.setAdapter(adapter);

        //обработчик клика
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                Bundle b = new Bundle();
                switch (i){
                    case 0:
                        intent.setClass(Prepods.this, Schedule.class);
                        b.putString("classID","1");
                        intent.putExtras(b);
                        startActivity(intent);
                        break;

                    case 1:
                        intent.setClass(Prepods.this, Schedule.class);
                        b.putString("classID","2");
                        intent.putExtras(b);
                        startActivity(intent);
                        break;

                    case 2:
                        intent.setClass(Prepods.this, Schedule.class);
                        b.putString("classID","3");
                        intent.putExtras(b);
                        startActivity(intent);
                        break;

                    case 3:
                        intent.setClass(Prepods.this, Schedule.class);
                        b.putString("classID","4");
                        intent.putExtras(b);
                        startActivity(intent);
                        break;

                    case 4:
                        intent.setClass(Prepods.this, Schedule.class);
                        b.putString("classID","5");
                        intent.putExtras(b);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
