package com.example.bkturizm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UyeOl2 extends AppCompatActivity {

    private TextView passwordBilgi;
    private EditText userName;
    private EditText regMail;
    private EditText regPassword;
    private EditText phoneNumber;
    private ProgressDialog regDialog;
    private String alertUyari;
    DatabaseHelper mDatabaseHelper;

    Button listele;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        alertUyari = "Şifreniz En Az 8 Haneli Olmalıdır."
                + System.getProperty("line.separator")
                + "1 Büyük , 1 Küçük Harf ve 1 Sembolden Oluşmalıdır."
                + System.getProperty("line.separator")
                + "Örnek Gösterim : BkTur123@";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye_ol);

        passwordBilgi = findViewById(R.id.passwordUyari);
        userName = findViewById(R.id.newName);
        regMail = findViewById(R.id.newUserMail);
        regPassword = findViewById(R.id.newUserPassword);
        phoneNumber = findViewById(R.id.newPhoneNumber);
        saveButton = findViewById(R.id.saveButton);
        listele = findViewById(R.id.btnListele);
        regDialog = new ProgressDialog(this);
        mDatabaseHelper = new DatabaseHelper(this);



        Button btngirisYap = findViewById(R.id.kayittanGirise);
        btngirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent3 = new Intent(UyeOl2.this, UyeGirisi.class);
                startActivity(myIntent3);
            }
        });


        passwordBilgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(UyeOl2.this);
                builder.setTitle("Şifre Hakkında");
                builder.setMessage(alertUyari);
                builder.setPositiveButton("Anladım.", null);
                builder.show();
            }
        });


        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {



                if (!isValidEmail(regMail.getText().toString().trim())) {
                    Toast.makeText(UyeOl2.this, "E-mail Yanlış", Toast.LENGTH_SHORT).show();
                    return;

                }

                if (!isValidPassword(regPassword.getText().toString().trim())) {
                    Toast.makeText(UyeOl2.this, "Şifre Yanlış", Toast.LENGTH_SHORT).show();
                    return;

                }

                String isim = userName.getText().toString();
                String mail = regMail.getText().toString();
                String sifre = regPassword.getText().toString();
                String telefon = phoneNumber.getText().toString();

                mDatabaseHelper = new DatabaseHelper(UyeOl2.this);
                mDatabaseHelper.addData(isim, mail, sifre, telefon);



                    regDialog.setTitle("Kayıt Yapılıyor...");
                    regDialog.setMessage("Aramıza Hoşgeldin Gezgin!");
                    regDialog.setCanceledOnTouchOutside(false);
                    regDialog.show();
                Intent yonlendir = new Intent(UyeOl2.this, MainActivity.class);
                startActivity(yonlendir);
                    return;

            }
        });


        listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yonlendir = new Intent(UyeOl2.this, ListDataActivity.class);
                startActivity(yonlendir);
            }
        });
    }


    public boolean isValidPassword( String password) {

        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

    public boolean isValidEmail(String email) {
        Pattern pattern1;
        Matcher matcher1;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern1 = Pattern.compile(EMAIL_PATTERN);
        matcher1 = pattern1.matcher(email);
        return matcher1.matches();
    }

}
