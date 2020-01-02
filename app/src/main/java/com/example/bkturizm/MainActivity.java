package com.example.bkturizm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private Button btnloginSayfasi;
    private Button btnkayitSayfasi;
    private Button btnUyeOlmaJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnloginSayfasi = findViewById(R.id.loginSayfasi);
        btnloginSayfasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, UyeGirisi.class);
                startActivity(myIntent);
            }
        });
        btnkayitSayfasi = findViewById(R.id.kayitSayfasi);
        btnkayitSayfasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent2 = new Intent(MainActivity.this, UyeOl2.class);
                startActivity(myIntent2);
            }
        });
        btnUyeOlmaJava = findViewById(R.id.btnUyeOlma);
        btnUyeOlmaJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Satın Almaya Yönlendiriliyor", Toast.LENGTH_SHORT).show();
                Intent myIntent3= new Intent(MainActivity.this, BiletAl.class);
                startActivity(myIntent3);
            }
        });
    }
}