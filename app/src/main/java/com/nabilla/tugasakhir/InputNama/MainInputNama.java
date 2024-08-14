package com.example.tugasakhir.InputNama;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasakhir.R;

public class MainInputNama extends AppCompatActivity {
    //Deklarasi Variable
    EditText TextNama;
    TextView Hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_input_nama);

        //Panggil Variable Berdasarkan id
        TextNama = (EditText) findViewById(R.id.TxtNama);
        Hasil = (TextView) findViewById(R.id.Lbl_Nama);
    }

    //Buat method Tampil Nama Sesuai dengan property Onclick pada Button
    public void TampilNama(View v){
        Hasil.setText("Nama Anda: "+TextNama.getText());
    }
}