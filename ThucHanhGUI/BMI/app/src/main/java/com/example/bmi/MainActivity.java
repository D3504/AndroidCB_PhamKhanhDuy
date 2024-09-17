package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edtTen, edtHeight, edtWeight, edtBMI, edtChanDoan;
    Button btnBMI, btnExit;

    public void tinhBMI(){
        edtTen = findViewById(R.id.edtTen);
        edtHeight = findViewById(R.id.edtHeight);
        edtWeight = findViewById(R.id.edtWeight);
        edtBMI = findViewById(R.id.edtBMI);
        edtChanDoan = findViewById(R.id.edtChanDoan);
        btnBMI = findViewById(R.id.btnBMI);
        btnExit = findViewById(R.id.btnExit);

        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double H = Double.parseDouble(edtHeight.getText().toString());
                double W = Double.parseDouble(edtWeight.getText().toString());
                double BMI = W/Math.pow(H, 2);
                String chandoan = "";

                if(BMI < 18){
                    chandoan = "Bạn gầy";
                }else if(BMI <= 24.9){
                    chandoan = "Bạn bình thường";
                }else if(BMI <= 29.9){
                    chandoan = "Bạn béo phì độ 1";
                }else if(BMI <= 34.9){
                    chandoan = "Bạn béo phì độ 2";
                }else{
                    chandoan = "Bạn béo phì độ 3";
                }
                DecimalFormat dcf = new DecimalFormat("#.0");
                edtBMI.setText(dcf.format(BMI));
                edtChanDoan.setText(chandoan);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
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
        tinhBMI();
    }
}