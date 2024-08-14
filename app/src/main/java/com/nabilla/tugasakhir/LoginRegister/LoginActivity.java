package com.example.tugasakhir.LoginRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.tugasakhir.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class LoginActivity extends AppCompatActivity {
    public static final String FILENAME = "login";

    EditText txtUsername, txtPassword;
    Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUsername = findViewById(R.id.txt_username);
        txtPassword = findViewById(R.id.txt_password);
        btnLogin = findViewById(R.id.action_login);
        btnRegister = findViewById(R.id.action_register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    void simpanFileLogin() {
        String isiFIle = txtUsername.getText().toString() + ";" + txtPassword.getText().toString();
        File file = new File(getFilesDir(), FILENAME);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(isiFIle.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();
        onBackPressed();
    }

    void login() {
        File sdcard = getFilesDir();
        File file = new File(sdcard, txtUsername.getText().toString());
        if (file.exists()) {
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                while (line != null) {
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String data = text.toString();
            String[] dataUser = data.split(";");

            if (dataUser[1].equals(txtPassword.getText().toString())) {
                simpanFileLogin();
                startActivity(new Intent(LoginActivity.this, MainLoginRegister.class));
                finish();
            } else {
                Toast.makeText(this, "Password tidak sesuai", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "User tidak ditemukan", Toast.LENGTH_SHORT).show();
        }
    }
}