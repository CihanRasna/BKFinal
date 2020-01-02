package com.example.bkturizm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

public class BiletAl extends AppCompatActivity {
    private Button tarihSayfaJava;
    private RadioGroup radioGroupJava;
    Button gidisPickerJava;
    Button donusPickerJava;
    RadioButton radioTekJava;
    TextView gidisTarihJava;
    TextView donusTarihJava;
    DatePickerDialog datePickerDialog;
    DatePickerDialog datePickerDialogDonus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilet_al);
        final AutoCompleteTextView gidisRota = findViewById(R.id.kalkisSehir);
        String[] sehirler = getResources().getStringArray(R.array.Sehirler);
        ArrayAdapter<String> adapter =
                new ArrayAdapter(this, android.R.layout.simple_list_item_activated_1, sehirler);
        gidisRota.setAdapter(adapter);

        final AutoCompleteTextView donusRota = findViewById(R.id.varisSehir);
        String[] sehirler2 = getResources().getStringArray(R.array.Sehirler);
        ArrayAdapter<String> adapter2 =
                new ArrayAdapter(this, android.R.layout.simple_list_item_activated_1, sehirler2);
        donusRota.setAdapter(adapter2);


        gidisPickerJava = findViewById(R.id.gidisPicker);
        gidisTarihJava = findViewById(R.id.gidisTarih);
        gidisPickerJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale locale = getResources().getConfiguration().locale;
                Locale.setDefault(locale);
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(BiletAl.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                gidisTarihJava.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, day);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();

            }
        });

        radioGroupJava = findViewById(R.id.radioGroup);
        radioGroupJava.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                radioTekJava = findViewById(R.id.radioTek);
                donusPickerJava = findViewById(R.id.donusPicker);
                donusTarihJava = findViewById(R.id.donusTarih);
                //donusPickerJava.setVisibility(View.GONE);
                //donusTarihJava.setVisibility(View.GONE);
                if (radioTekJava.isChecked()) {
                    gidisPickerJava.setVisibility(View.VISIBLE);
                    gidisTarihJava.setVisibility(View.VISIBLE);
                    donusPickerJava.setVisibility(View.GONE);
                    donusTarihJava.setVisibility(View.GONE);
                } else {
                    gidisPickerJava.setVisibility(View.VISIBLE);
                    gidisTarihJava.setVisibility(View.VISIBLE);
                    donusPickerJava.setVisibility(View.VISIBLE);
                    donusTarihJava.setVisibility(View.VISIBLE);
                    donusPickerJava.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Locale locale = getResources().getConfiguration().locale;
                            Locale.setDefault(locale);
                            Calendar calendar = Calendar.getInstance();
                            int year = calendar.get(Calendar.YEAR);
                            int month = calendar.get(Calendar.MONTH);
                            int day = calendar.get(Calendar.DAY_OF_MONTH);
                            datePickerDialogDonus = new DatePickerDialog(BiletAl.this,
                                    new DatePickerDialog.OnDateSetListener() {
                                        @Override
                                        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                            donusTarihJava.setText(day + "/" + (month + 1) + "/" + year);
                                        }
                                    }, year, month, day);
                            datePickerDialogDonus.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                            datePickerDialogDonus.show();

                        }
                    });
                }

            }
        });



        tarihSayfaJava = findViewById(R.id.tarihSecim);
        tarihSayfaJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nereden = gidisRota.getText().toString();
                String nereye = donusRota.getText().toString();
                String tarih = gidisTarihJava.getText().toString();
                String donus = donusTarihJava.getText().toString();


                if (nereden.equals(nereye)) {
                    Toast.makeText(BiletAl.this, "Varış Noktası Kalkış Noktasıyla aynı olamaz..", Toast.LENGTH_SHORT).show();
                } else if (tarih.isEmpty()) {
                    Toast.makeText(BiletAl.this, "Tarih boş olamaz..", Toast.LENGTH_SHORT).show();
                } else {
                    Intent veriTasi = new Intent(BiletAl.this, saatSecimi.class);
                    veriTasi.putExtra("nereden", nereden);
                    veriTasi.putExtra("nereye", nereye);
                    veriTasi.putExtra("tarih", tarih);
                    veriTasi.putExtra("donus", donus);
                    startActivity(veriTasi);
                }
            }
        });
    }
}
