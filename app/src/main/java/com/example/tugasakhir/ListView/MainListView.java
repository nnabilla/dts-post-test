package com.example.tugasakhir.ListView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasakhir.R;

public class MainListView extends AppCompatActivity {

    //mendeklarasikan listview var dan menginisialasi array tipe data string
    private ListView lvItem;
    private String[] namanegara = new String[]{
            "Indonesia","Malaysia","Singapore" ,
            "Italia", "Inggris", "Belanda",
            "Argentina","Chile",
            "Mesir", "Uganda"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_view);

        getSupportActionBar().setTitle("ListView Sederhana"); //tampil judul

        //Membinding atau memformat data
        lvItem = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainListView.this,
                android.R.layout.simple_list_item_1, android.R.id.text1, namanegara);

        //menset data di dalam listview
        lvItem.setAdapter(adapter);

        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainListView.this,
                        "Memilih : "+namanegara[position], Toast.LENGTH_LONG).show();
            }
        });
    }
}