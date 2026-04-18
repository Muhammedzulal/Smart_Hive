package com.example.smarthive;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginMenu extends AppCompatActivity {
    Button btnGiris;
    EditText loginTxtBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_menu);
        btnGiris = findViewById(R.id.button);
        loginTxtBox = findViewById(R.id.loginTxtBox);
    }

    public void btnGiris(View view) {
      if(loginTxtBox.getText().toString().equals("0123456789")) {
          Intent intent = new Intent(this, ProfileMenu.class);
          startActivity(intent);
      }
    }
}