package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edUsername;
    EditText edPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // sambungkan ke xml
        edUsername = (EditText) findViewById(R.id.edUsername);
        edPassword = (EditText) findViewById(R.id.edPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // logic btn login untuk mengecek apakah username dan password sesuai
                if (edUsername.getText().toString().equals("admin")
                        && edPassword.getText().toString().equals("admin123")) {
                    Toast.makeText(MainActivity.this, "Selamat Anda Benar", Toast.LENGTH_SHORT).show();
                    Intent toCalculator = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(toCalculator);
                } else {
                    Toast.makeText(MainActivity.this, "Yah Anda Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}