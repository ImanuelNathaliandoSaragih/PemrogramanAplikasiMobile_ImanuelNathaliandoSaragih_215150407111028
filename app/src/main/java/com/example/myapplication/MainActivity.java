package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText textNum1, textNum2;
    private RadioGroup countType;
    private Button hitung;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        textNum1 = findViewById(R.id.textNum1);
        textNum2 = findViewById(R.id.textNum2);
        countType = findViewById(R.id.countType);
        hitung = findViewById(R.id.hitung);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });


    }


    private void calculate(){
        String num1str = textNum1.getText().toString();
        String num2str = textNum2.getText().toString();

        if(num1str.isEmpty() || num2str.isEmpty()){
            Toast.makeText(this, "Mohon masukkan angka",Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(num1str);
        double num2 = Double.parseDouble(num2str);
        double hasil = 0;

        int selectedId = countType.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(this, "Pilih Tipe Operasi", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selectedCount = findViewById(selectedId);
        String selectedCountStr = selectedCount.getText().toString();

        Log.d("Pilihan metode", selectedCountStr );
        Log.d("num1", String.valueOf(num1));
        Log.d("num2", String.valueOf(num2));

        if(selectedCountStr.equals("+")){
           hasil = num1 + num2;
        } else if (selectedCountStr.equals("-")) {
            hasil = num1 - num2;
        } else if (selectedCountStr.equals("*")) {
            hasil = num1 * num2;
        } else if (selectedCountStr.equals("/")) {
            if(num2 == 0){
                Toast.makeText(this, "Angka Kedua tidak boleh 0",Toast.LENGTH_SHORT).show();
                return;
            }else {
                hasil = num1 / num2;
            }
        }

        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("hasil",hasil);
        startActivity(intent);

    }

}
