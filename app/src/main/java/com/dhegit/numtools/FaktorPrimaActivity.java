package com.dhegit.numtools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class FaktorPrimaActivity extends AppCompatActivity {
    private EditText etInputAngka;
    private TextView tvClose, tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faktor_prima);

        etInputAngka = findViewById(R.id.et_input_angka);
        tvOutput = findViewById(R.id.tv_output);
        tvClose = findViewById(R.id.tv_close);

        tvClose.setOnClickListener(view -> {
            onBackPressed();
        });
    }

    public void faktorPrima(View view) {
        String inputan = etInputAngka.getText().toString().trim();

        if (inputan.length() > 0) {
            String[] stringsNumbers = inputan.split(" ");
            Integer[] integersNumbers = new Integer[stringsNumbers.length];

            for (int i=0; i<stringsNumbers.length; i++){
                integersNumbers[i] = Integer.parseInt(stringsNumbers[i]);
            }

            Arrays.sort(integersNumbers);

            int[] hsl = new int [10];
            int index = 0;
            tvOutput.setText(String.valueOf(" "));

            for(int i = 2; i< integersNumbers[0]; i++) {
                while(integersNumbers[0]%i == 0) {
                    hsl[index] = i;
                    integersNumbers[0] = integersNumbers[0]/i;
                    index++;
                }
            }
            if(integersNumbers[0] >2) {
                hsl[index] = integersNumbers[0];
                index++;
            }

            for(int k = 0; k < index; k++){

                tvOutput.append(hsl[k] + " ");
            }
        } else {
            Toast.makeText(getApplicationContext(), "Silakan masukkan angka terlebih dahulu", Toast.LENGTH_SHORT).show();
        }
    }
}