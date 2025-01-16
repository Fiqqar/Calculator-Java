package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    EditText edAngka1;
    EditText edAngka2;
    Button btnTambah;
    Button btnKurang;
    Button btnKali;
    Button btnBagi;
    Button btnClear;
    TextView txtHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        edAngka1 = (EditText) findViewById(R.id.edAngka1);
        edAngka2 = (EditText) findViewById(R.id.edAngka2);
        btnTambah = (Button) findViewById(R.id.btnTambah);
        btnKurang = (Button) findViewById(R.id.btnKurang);
        btnKali = (Button) findViewById(R.id.btnKali);
        btnBagi = (Button) findViewById(R.id.btnBagi);
        btnClear = (Button) findViewById(R.id.btnClear);
        txtHasil = (TextView) findViewById(R.id.txtHasil);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil('+');
            }
        });
        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil('-');
            }
        });
        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil('*');
            }
        });
        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil('/');
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClearText();
            }
        });
    };
    private void ClearText() {
        edAngka1.setText("");
        edAngka2.setText("");
        txtHasil.setText("Hasil : ");
        Toast.makeText(this, "Input Clear", Toast.LENGTH_SHORT).show();
    }

    private void hasil(char operasi) {
        double hitungan = 0;

        double a1 = Double.parseDouble(edAngka1.getText().toString());
        double a2 = Double.parseDouble(edAngka2.getText().toString());

        if (operasi == '+') {
            hitungan = tambah(a1, a2);
            txtHasil.setText("Hasil : " + hitungan);
        } else if (operasi == '-') {
            hitungan = kurang(a1, a2);
            txtHasil.setText("Hasil : " + hitungan);
        } else if (operasi == '*') {
            hitungan = kali(a1, a2);
            txtHasil.setText("Hasil : " + hitungan);
        } else if (operasi == '/') {
            if (a2 != 0) {
                hitungan = bagi(a1, a2);
                txtHasil.setText("Hasil : " + hitungan);
            } else {
                Toast.makeText(this, "Angka tidak bisa dibagi 0", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }

    private double tambah(double a1, double a2) {
        return a1 + a2;
    }

    private double kurang(double a1, double a2) {
        return a1 - a2;
    }

    private double kali(double a1, double a2) {
        return a1 * a2;
    }

    private double bagi(double a1, double a2) {
        return a1 / a2;
    }
}