package com.example.bkturizm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class UyeGirisi extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText loginText;
    private EditText loginPassword;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye_girisi);
        loginText = findViewById(R.id.editUsername);
        loginPassword = findViewById(R.id.editPassword);
        loginButton = findViewById(R.id.UyeGiris);

    }
}
