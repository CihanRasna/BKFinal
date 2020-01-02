package com.example.bkturizm;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class saatSecimi extends AppCompatActivity {

    private TextView seferKalkis1, seferVaris1, seferKalkis2, seferVaris2, seferKalkis3, seferVaris3;
    private Button saat1, saat2, saat3;
    private TextView fiyat1, fiyat2, fiyat3;
    DatabaseHelper m2DatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saat_secimi);

        m2DatabaseHelper = new DatabaseHelper(this);
        seferKalkis1 = findViewById(R.id.seferKalkis1);
        seferKalkis2 = findViewById(R.id.seferKalkis2);
        seferKalkis3 = findViewById(R.id.seferKalkis3);
        seferVaris1 = findViewById(R.id.seferVaris1);
        seferVaris2 = findViewById(R.id.seferVaris2);
        seferVaris3 = findViewById(R.id.seferVaris3);
        saat1 = findViewById(R.id.saat1);
        saat2 = findViewById(R.id.saat2);
        saat3 = findViewById(R.id.saat3);
        fiyat1 = findViewById(R.id.fiyat1);
        fiyat2 = findViewById(R.id.fiyat2);
        fiyat3 = findViewById(R.id.fiyat3);




        Intent gonder = getIntent();
        Bundle yazdir = gonder.getExtras();

        if (yazdir != null) {
            String kalkis1 = (String) yazdir.get("nereden");
            seferKalkis1.setText(kalkis1);
            String varis1 = (String) yazdir.get("nereye");
            seferVaris1.setText(varis1);
            String kalkis2 = (String) yazdir.get("nereden");
            seferKalkis2.setText(kalkis2);
            String varis2 = (String) yazdir.get("nereye");
            seferVaris2.setText(varis2);
            String kalkis3 = (String) yazdir.get("nereden");
            seferKalkis3.setText(kalkis3);
            String varis3 = (String) yazdir.get("nereye");
            seferVaris3.setText(varis3);
        }

        saat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                String saat = "12:00";
                String kalkis = seferKalkis1.getText().toString();
                String varis = seferVaris1.getText().toString();
                String fiyat = fiyat1.getText().toString();

                m2DatabaseHelper = new DatabaseHelper(saatSecimi.this);
                m2DatabaseHelper.addSeferData(saat, kalkis, varis, fiyat);
                Intent tercih = new Intent(saatSecimi.this, rezervasyonlar.class);
                startActivity(tercih);

            }

        });

        saat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                String saat = "16:30";
                String kalkis = seferKalkis2.getText().toString();
                String varis = seferVaris2.getText().toString();
                String fiyat = fiyat2.getText().toString();

                m2DatabaseHelper = new DatabaseHelper(saatSecimi.this);
                m2DatabaseHelper.addSeferData(saat, kalkis, varis, fiyat);
                Intent tercih = new Intent(saatSecimi.this, rezervasyonlar.class);
                startActivity(tercih);

            }

        });

        saat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                String saat = "21:00";
                String kalkis = seferKalkis3.getText().toString();
                String varis = seferVaris3.getText().toString();
                String fiyat = fiyat3.getText().toString();

                m2DatabaseHelper = new DatabaseHelper(saatSecimi.this);
                m2DatabaseHelper.addSeferData(saat, kalkis, varis, fiyat);
                Intent tercih = new Intent(saatSecimi.this, rezervasyonlar.class);
                startActivity(tercih);

            }

        });

    }
}
