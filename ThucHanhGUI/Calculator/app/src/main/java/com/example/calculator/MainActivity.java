package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText txtA, txtB;
    TextView txtResult;
    Button btnPlus, btnMinus, btnMulti, btnDivide, btnUoc, btnThoat;

    private void innitControl(){
        txtA = findViewById(R.id.edtA);
        txtB = findViewById(R.id.edtB);
        txtResult = findViewById(R.id.txtResult);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMulti = findViewById(R.id.btnMulti);
        btnDivide = findViewById(R.id.btnDivide);
        btnUoc = findViewById(R.id.btnUoc);
        btnThoat = findViewById(R.id.btnThoat);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(txtA.getText().toString());
                int b = Integer.parseInt(txtB.getText().toString());
                int result = a + b;
                txtResult.setText(String.valueOf(result));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(txtA.getText().toString());
                int b = Integer.parseInt(txtB.getText().toString());
                int result = a - b;
                txtResult.setText(String.valueOf(result));
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(txtA.getText().toString().trim());
                int b = Integer.parseInt(txtB.getText().toString().trim());
                int result = a * b;
                txtResult.setText(String.valueOf(result));
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(txtA.getText().toString());
                int b = Integer.parseInt(txtB.getText().toString());
                int result = a / b;
                txtResult.setText(String.valueOf(result));
            }
        });

        btnUoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int gcd = 1;
                int a = Integer.parseInt(txtA.getText().toString());
                int b = Integer.parseInt(txtB.getText().toString());
                for (int i = 1; i <= a && i <= b; i++) {
                    if (a % i == 0 && b % i == 0) {
                        gcd = i;
                    }
                }
                txtResult.setText(String.valueOf(gcd));
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        innitControl();
    }
}