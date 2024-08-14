package com.example.tugasakhir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.tugasakhir.CatatanHarian.MainCatatanHarian;
import com.example.tugasakhir.DataRoti.MainDataRoti;
import com.example.tugasakhir.InputNama.MainInputNama;
import com.example.tugasakhir.Kalkulator.MainKalkulator;
import com.example.tugasakhir.ListView.MainListView;
import com.example.tugasakhir.LoginRegister.SplashScreenActivity;

public class MainActivity extends AppCompatActivity {
    private CardView card_input, card_kalkulator, card_list, card_catatan, card_loginreg, card_sqlite, card_dataroti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        card_input = findViewById(R.id.card_input);
        card_kalkulator = findViewById(R.id.card_kalkulator);
        card_list = findViewById(R.id.card_list);
        card_catatan = findViewById(R.id.card_catatan);
        card_loginreg = findViewById(R.id.card_loginreg);
        card_dataroti = findViewById(R.id.card_dataroti);

        card_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(view.getContext(), MainInputNama.class);
                startActivity(a);
                finish();
            }
        });

        card_kalkulator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(view.getContext(), MainKalkulator.class);
                startActivity(a);
                finish();
            }
        });

        card_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(view.getContext(), MainListView.class);
                startActivity(a);
                finish();
            }
        });

        card_catatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(view.getContext(), MainCatatanHarian.class);
                startActivity(a);
                finish();
            }
        });

        card_loginreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(view.getContext(), SplashScreenActivity.class);
                startActivity(a);
                finish();
            }
        });

        card_dataroti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(view.getContext(), MainDataRoti.class);
                startActivity(a);
                finish();
            }
        });
    }
}