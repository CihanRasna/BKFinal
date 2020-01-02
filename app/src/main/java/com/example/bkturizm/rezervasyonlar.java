package com.example.bkturizm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class rezervasyonlar extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    private ListView rezerveListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezervasyonlar);
        rezerveListView = findViewById(R.id.listViewRezervasyon);
        mDatabaseHelper = new DatabaseHelper(this);
        rezervasyonListele();

    }

    private void rezervasyonListele() {
        DatabaseHelper mDatabaseHelper = new DatabaseHelper(rezervasyonlar.this);
        List<String> list = mDatabaseHelper.rezervasyonListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(rezervasyonlar.this,
                android.R.layout.simple_list_item_1, android.R.id.text1, list);
        rezerveListView.setAdapter(adapter);
    }
}
