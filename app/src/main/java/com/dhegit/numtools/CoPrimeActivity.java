package com.dhegit.numtools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class CoPrimeActivity extends AppCompatActivity {
    private EditText etInputAngka;
    private TextView tvClose, tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_prime);

        etInputAngka = findViewById(R.id.et_input_angka);
        tvOutput = findViewById(R.id.tv_output);
        tvClose = findViewById(R.id.tv_close);

        tvClose.setOnClickListener(view -> {
            onBackPressed();
        });
    }

    public void coPrime(View view) {
        String input = etInputAngka.getText().toString().trim();

        String[] stringsNumbers = input.split(" ");
        Integer[] integersNumbers = new Integer[stringsNumbers.length];

        if (input.length() > 0) {
            for (int i=0; i<stringsNumbers.length; i++){
                integersNumbers[i] = Integer.parseInt(stringsNumbers[i]);
            }

            Arrays.sort(integersNumbers);

            int GCD = 1;
            int intRemainder;

            //GCD
            for (int i = 2; i<=integersNumbers[0]; i++){
                intRemainder = 0;

                for(int j=0;j<integersNumbers.length; j++){
                    if(integersNumbers[j]%i != 0){
                        intRemainder = 1;
                        break;
                    }
                }

                if (intRemainder == 0){
                    GCD = i;
                }
            }

            //Co-Prime
            if (GCD == 1){
                tvOutput.setText(String.valueOf("co-prime"));
            } else {
                tvOutput.setText(String.valueOf("not co-prime"));
            }
        } else  {
            Toast.makeText(this, "Silakan masukkan angka terlebih dahulu", Toast.LENGTH_SHORT).show();
        }
    }
}