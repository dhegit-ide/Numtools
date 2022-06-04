package com.dhegit.numtools;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Fragment> list = new ArrayList<>();
        list.add(new MenuPage());
        list.add(new CreditPage());

        pager = findViewById(R.id.slide_page);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(), list);

        pager.setAdapter(pagerAdapter);
    }

    public void btnGcdLcm(View view) {
        Intent intent = new Intent(this, GcdLcmActivity.class);
        startActivity(intent);
    }

    public void btnCoPrimes(View view) {
        Intent intent = new Intent(this, CoPrimeActivity.class);
        startActivity(intent);
    }

    public void btnFaktorisasi(View view) {
        Intent intent = new Intent(this, FaktorPrimaActivity.class);
        startActivity(intent);
    }

    public void btnListPrima(View view) {
        Intent intent = new Intent(this, ListPrimaActivity.class);
        startActivity(intent);
    }

    public void btnKongruensi(View view) {
        Intent intent = new Intent(this, KongruensiActivity.class);
        startActivity(intent);
    }
}