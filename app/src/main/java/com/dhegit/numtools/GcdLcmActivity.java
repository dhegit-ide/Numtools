package com.dhegit.numtools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class GcdLcmActivity extends AppCompatActivity {
    private EditText etInputAngka;
    private TextView tvClose, tvOutputGcd, tvOutputLcm, tvGcd, tvLcm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcd_lcm);

        etInputAngka = findViewById(R.id.et_input_angka);
        tvOutputGcd = findViewById(R.id.tv_output_gcd);
        tvOutputLcm = findViewById(R.id.tv_output_lcm);
        tvGcd = findViewById(R.id.tv_gcd);
        tvLcm = findViewById(R.id.tv_lcm);
        tvClose = findViewById(R.id.tv_close);

        tvClose.setOnClickListener(view -> {
            onBackPressed();
        });
    }

    public void gcdLcm(View view) {
        String input = etInputAngka.getText().toString().trim();

        String[] stringsNumbers = input.split(" ");
        Integer[] integersNumbers = new Integer[stringsNumbers.length];

        if (input.length() > 0) {
            for (int i=0; i<stringsNumbers.length; i++){
                integersNumbers[i] = Integer.parseInt(stringsNumbers[i]);
            }

            Arrays.sort(integersNumbers);

            int gcd = 1;
            int intRemainder;
            int lcm = 1;

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
                    gcd = i;
                }
            }

            //LCM
            for (int a = 0; a < integersNumbers.length; a++){
                int gcd2var = findGCD(integersNumbers[a], lcm);
                lcm = lcm * integersNumbers[a] / gcd2var;
            }

            tvGcd.setText(String.valueOf("GCD"));
            tvLcm.setText(String.valueOf("LCM"));
            tvOutputGcd.setText(String.valueOf(gcd));
            tvOutputLcm.setText(String.valueOf(lcm));
        } else {
            Toast.makeText(this, "Silakan masukkan angka terlebih dahulu", Toast.LENGTH_SHORT).show();
        }
    }

    // find GCD of two numbers
    private int findGCD(int a, int b) {
        if(b == 0)
            return a;
        return  findGCD(b, a%b);
    }
}