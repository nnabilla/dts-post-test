package com.example.tugasakhir.LoginRegister;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasakhir.R;

import java.io.File;
import java.io.FileOutputStream;

public class RegisterActivity extends AppCompatActivity {

    EditText editUsername, editPassword, editEmail, editNamaLengkap, editAsalSekolah, editAlamatTinggal;
    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Register");

        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        editEmail = findViewById(R.id.editEmail);
        editNamaLengkap = findViewById(R.id.editNamaLengkap);
        editAsalSekolah = findViewById(R.id.editAsalSekolah);
        editAlamatTinggal = findViewById(R.id.editAlamatTinggal);
        btnSimpan = findViewById(R.id.btnSimpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isvalidation()){
                    simpanFileData();
                }else{
                    Toast.makeText(RegisterActivity.this, "Mohon Lengkapi Data Terlebih Dahulu", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    boolean isvalidation(){
        if(editUsername.getText().toString().equals("") ||
                editPassword.getText().toString().equals("") ||
                editEmail.getText().toString().equals("") ||
                editNamaLengkap.getText().toString().equals("") ||
                editAsalSekolah.getText().toString().equals("") ||
                editAlamatTinggal.getText().toString().equals("")){
            return false;
        }else{
            return true;
        }
    }

    void simpanFileData(){
        String isiFile = editUsername.getText().toString()+";"+
                editPassword.getText().toString()+";"+
                editEmail.getText().toString()+";"+
                editNamaLengkap.getText().toString()+";"+
                editAsalSekolah.getText().toString()+";"+
                editAlamatTinggal.getText().toString();
        File file = new File(getFilesDir(), editUsername.getText().toString());

        FileOutputStream outputStream = null;
        try{
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        Toast.makeText(this, "register berhasil", Toast.LENGTH_SHORT).show();
        onBackPressed();
    }
}