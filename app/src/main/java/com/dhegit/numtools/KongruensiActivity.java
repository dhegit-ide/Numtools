package com.dhegit.numtools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class KongruensiActivity extends AppCompatActivity {
    private EditText etInputAngka;
    private TextView tvClose, tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kongruensi);

        etInputAngka = findViewById(R.id.et_input_angka);
        tvOutput = findViewById(R.id.tv_output);
        tvClose = findViewById(R.id.tv_close);

        tvClose.setOnClickListener(view -> {
            onBackPressed();
        });
    }

    public void kongruensi(View view) {
        String inputan = etInputAngka.getText().toString().trim();

        if (inputan.length() > 0) {
            String[] stringsNumbers = inputan.split(" ");
            Integer[] integersNumbers = new Integer[stringsNumbers.length];

            for (int i=0; i<stringsNumbers.length; i++){
                integersNumbers[i] = Integer.parseInt(stringsNumbers[i]);
            }

            Arrays.sort(integersNumbers);

            int a = integersNumbers[2];
            int b = integersNumbers[0];
            int n = integersNumbers[1];


            int hasil = (a-b) % n;

            if (hasil == 0){
                tvOutput.setText(String.valueOf("True"));
            } else {
                tvOutput.setText(String.valueOf("False"));
            }
        } else {
            Toast.makeText(getApplicationContext(), "Silakan masukkan angka terlebih dahulu", Toast.LENGTH_SHORT).show();
        }
    }
}