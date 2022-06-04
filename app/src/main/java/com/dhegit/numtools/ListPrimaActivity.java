package com.dhegit.numtools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class ListPrimaActivity extends AppCompatActivity {
    private EditText etInputAngka;
    private TextView tvClose, tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_prima);

        etInputAngka = findViewById(R.id.et_input_angka);
        tvOutput = findViewById(R.id.tv_output);
        tvClose = findViewById(R.id.tv_close);

        tvClose.setOnClickListener(view -> {
            onBackPressed();
        });
    }

    public void listPrima(View view) {
        String inputan = etInputAngka.getText().toString().trim();

        if (inputan.length() > 0) {
            String[] stringsNumbers = inputan.split(" ");
            Integer[] integersNumbers = new Integer[stringsNumbers.length];

            for (int i=0; i<stringsNumbers.length; i++){
                integersNumbers[i] = Integer.parseInt(stringsNumbers[i]);
            }

            Arrays.sort(integersNumbers);

            int awal, akhir, bil;
            tvOutput.setText(String.valueOf(" "));

            awal = integersNumbers[0];
            akhir = integersNumbers[1];

            for (int i=awal; i<=akhir; i++){
                bil=0;
                for (int j=1;j<=i;j++){
                    if (i%j==0){
                        bil=bil+1;
                    }
                }
                if (bil==2){
                    tvOutput.append(i + " ");
                    tvOutput.setMovementMethod(new ScrollingMovementMethod());
                }
            }
        } else {
            Toast.makeText(getApplicationContext(), "Silakan masukkan angka terlebih dahulu", Toast.LENGTH_SHORT).show();
        }
    }
}