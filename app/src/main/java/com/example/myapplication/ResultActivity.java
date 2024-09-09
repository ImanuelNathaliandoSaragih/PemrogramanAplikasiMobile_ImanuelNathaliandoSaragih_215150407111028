package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class ResultActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);
        TextView hasil = findViewById(R.id.hasil);
        TextView nama = findViewById(R.id.nama);
        TextView nim = findViewById(R.id.nim);

        double result = getIntent().getDoubleExtra("hasil",0);
        hasil.setText("Hasil Perhitungan = " + result);
        nama.setText("Nama : IMANUEL NATHALIANDO SARAGIH");
        nim.setText("NIM : 2151510407111028");




    }
}
