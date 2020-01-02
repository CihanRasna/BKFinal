package com.example.bkturizm;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ListDataActivity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        mListView = findViewById(R.id.listView);
        mDatabaseHelper = new DatabaseHelper(this);
        populateListView();

    }

    private void populateListView() {
        DatabaseHelper mDatabaseHelper = new DatabaseHelper(ListDataActivity.this);
        List<String> list = mDatabaseHelper.kisiListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ListDataActivity.this,
                android.R.layout.simple_list_item_1, android.R.id.text1, list);
        mListView.setAdapter(adapter);
    }


}