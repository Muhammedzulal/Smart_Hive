package com.example.smarthive;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class KovanlarMenu extends AppCompatActivity {
    ListView listView;
    private ArrayAdapter<String> adapter;
    private String[] kovanlar = {"Kovan 1", "Kovan 2", "Kovan 3", "Kovan 4", "Kovan 5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kovanlar_menu);
        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, kovanlar);
        listView.setAdapter(adapter);
        //Tıklanınca
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String secilenKovan = parent.getItemAtPosition(position).toString();
                Toast.makeText(KovanlarMenu.this, secilenKovan + " seçildi", Toast.LENGTH_SHORT).show();
                //Tıklanan kovanın ekranını aç
                Intent intent = new Intent(KovanlarMenu.this, KovanScreen.class);
                startActivity(intent);
            }
        });
    }
}