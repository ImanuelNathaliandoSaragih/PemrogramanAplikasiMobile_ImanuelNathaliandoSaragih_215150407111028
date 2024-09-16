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
    private TextView display;
    private String currentInput = "";
    private String operator = "";
    private double operand1 = 0, operand2 = 0;
    private boolean operatorPressed = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        display = findViewById(R.id.display);

        setNumberButtonListener(R.id.button0, "0");
        setNumberButtonListener(R.id.button1, "1");
        setNumberButtonListener(R.id.button2, "2");
        setNumberButtonListener(R.id.button3, "3");
        setNumberButtonListener(R.id.button4, "4");
        setNumberButtonListener(R.id.button5, "5");
        setNumberButtonListener(R.id.button6, "6");
        setNumberButtonListener(R.id.button7, "7");
        setNumberButtonListener(R.id.button8, "8");
        setNumberButtonListener(R.id.button9, "9");

        setOperatorButtonListener(R.id.add, "+");
        setOperatorButtonListener(R.id.subtract, "-");
        setOperatorButtonListener(R.id.multiply, "*");
        setOperatorButtonListener(R.id.divide, "/");

        Button buttonEqual = findViewById(R.id.res);
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!operator.isEmpty() && !currentInput.isEmpty()) {
                    operand2 = Double.parseDouble(currentInput);
                    double result = calculateResult();
                    display.setText(String.valueOf(result));
                    resetCalculator();
                    currentInput = String.valueOf(result);
                    operatorPressed = true;
                }
            }
        });

        Button buttonClear = findViewById(R.id.clear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCalculator();
                display.setText("0");
            }
        });
    }

    private void setNumberButtonListener(int buttonId, String number) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operatorPressed) {
                    currentInput = "";
                    operatorPressed = false;
                }
                currentInput += number;
                display.setText(currentInput);
            }
        });
    }

    private void setOperatorButtonListener(int buttonId, String op) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentInput.isEmpty()) {
                    operand1 = Double.parseDouble(currentInput);
                    operator = op;
                    operatorPressed = true;
                }
            }
        });
    }

    private double calculateResult() {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    display.setText("Error");
                    return 0;
                }
            default:
                return 0;
        }
    }

    private void resetCalculator() {
        currentInput = "";
        operator = "";
        operand1 = 0;
        operand2 = 0;
        operatorPressed = false;
    }

}
