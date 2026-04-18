package com.example.smarthive;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KovanlarMenu extends AppCompatActivity {
    ListView listView;
    // Artık ArrayAdapter değil, KENDİ adapter'ımızı kullanıyoruz
    private KovanAdapter adapter;

    private String[] kovanlar = {"Kovan 1", "Kovan 2", "Kovan 3", "Kovan 4", "Kovan 5",
            "Kovan 6", "Kovan 7", "Kovan 8", "Kovan 9", "Kovan 10", "Kovan 11", "Kovan 12",
            "Kovan 13", "Kovan 14", "Kovan 15", "Kovan 16", "Kovan 17", "Kovan 18", "Kovan 19","Kovan 20"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Bu ismin önceki adımda tasarladığımız XML dosyasıyla (kovanlar_menu.xml vs) aynı olduğuna emin ol
        setContentView(R.layout.kovanlar_menu);

        listView = findViewById(R.id.listView);

        // String dizisini List yapısına çeviriyoruz (Adapter'lar bununla daha pürüzsüz çalışır)
        List<String> kovanListesi = new ArrayList<>(Arrays.asList(kovanlar));

        // Hazırladığımız KovanAdapter'ı çağırıp listeye set ediyoruz
        adapter = new KovanAdapter(this, kovanListesi);
        listView.setAdapter(adapter);

        // Tıklanınca
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Kendi adapter'ımızdan seçilen nesneyi alıyoruz
                String secilenKovan = adapter.getItem(position);
                Toast.makeText(KovanlarMenu.this, secilenKovan + " seçildi", Toast.LENGTH_SHORT).show();

                // Tıklanan kovanın ekranını aç
                Intent intent = new Intent(KovanlarMenu.this, KovanScreen.class);
                // İstersen seçilen kovanın adını KovanScreen sayfasına şu şekilde gönderebilirsin:
                intent.putExtra("SECILEN_KOVAN_ADI", secilenKovan);
                startActivity(intent);
            }
        });
    }
}