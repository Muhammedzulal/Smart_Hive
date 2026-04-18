package com.example.smarthive;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileMenu extends AppCompatActivity {
    Button BtnGecis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_menu);
        BtnGecis = findViewById(R.id.BtnGecis);
        BtnGecis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileMenu.this, KovanlarMenu.class);
                startActivity(intent);
            }
        });
    }

}
