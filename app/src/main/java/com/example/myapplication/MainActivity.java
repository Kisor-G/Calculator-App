package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String input = "";
    private String operator = "";
    private double firstOperand = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        // Number Buttons
        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);

        // Operator Buttons
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSubtract = findViewById(R.id.btnSubtract);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btnEqual = findViewById(R.id.btnEqual);
        Button btnClear = findViewById(R.id.btnClear);

        // Set click listeners for number buttons
        View.OnClickListener numberListener = v -> {
            input += ((Button) v).getText().toString();
            display.setText(input);
        };

        btn0.setOnClickListener(numberListener);
        btn1.setOnClickListener(numberListener);
        btn2.setOnClickListener(numberListener);
        btn3.setOnClickListener(numberListener);
        btn4.setOnClickListener(numberListener);
        btn5.setOnClickListener(numberListener);
        btn6.setOnClickListener(numberListener);
        btn7.setOnClickListener(numberListener);
        btn8.setOnClickListener(numberListener);
        btn9.setOnClickListener(numberListener);

        // Set click listeners for operator buttons
        View.OnClickListener operatorListener = v -> {
            if (!input.isEmpty()) {
                firstOperand = Double.parseDouble(input);
                operator = ((Button) v).getText().toString();
                input = "";
            }
        };

        btnAdd.setOnClickListener(operatorListener);
        btnSubtract.setOnClickListener(operatorListener);
        btnMultiply.setOnClickListener(operatorListener);
        btnDivide.setOnClickListener(operatorListener);

        // Set click listener for the equal button
        btnEqual.setOnClickListener(v -> {
            if (!input.isEmpty()) {
                double secondOperand = Double.parseDouble(input);
                double result = performCalculation(firstOperand, secondOperand, operator);
                display.setText(String.valueOf(result));
                input = "";
                operator = "";
            }
        });

        // Set click listener for the clear button
        btnClear.setOnClickListener(v -> {
            input = "";
            operator = "";
            display.setText(getString(R.string.default_display_text));
            firstOperand = 0;
        });
    }

    private double performCalculation(double firstOperand, double secondOperand, String operator) {
        switch (operator) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                return secondOperand != 0 ? firstOperand / secondOperand : 0; // Handle division by zero
            default:
                return 0;
        }
    }
}
