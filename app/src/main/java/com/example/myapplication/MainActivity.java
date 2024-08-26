package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        TextView textNama = findViewById(R.id.nama);
        TextView textNIM = findViewById(R.id.nim);

        textNama.setText("Imanuel Nathaliando Saragih");
        textNIM.setText("215150407111028");


    }
}
