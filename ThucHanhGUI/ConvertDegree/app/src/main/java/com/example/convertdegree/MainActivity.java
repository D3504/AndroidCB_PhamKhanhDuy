package com.example.convertdegree;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtC, edtF;
    Button btnC, btnF, btnClear;

    private void innitControl(){
        edtC = findViewById(R.id.edtC);
        edtF = findViewById(R.id.edtF);
        btnC = findViewById(R.id.btnC);
        btnF = findViewById(R.id.btnF);
        btnClear = findViewById(R.id.btnClear);

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int C = Integer.parseInt(edtC.getText().toString().trim());
                Double F = (double)C*1.8 + 32;
                edtF.setText(String.valueOf(F));
            }
        });

        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int F = Integer.parseInt(edtF.getText().toString().trim());
                Double C = (F-32)/1.8;
                edtC.setText(String.valueOf(C));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtF.setText("");
                edtC.setText("");
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