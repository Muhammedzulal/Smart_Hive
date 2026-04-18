package com.example.smarthive;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class KovanAdapter extends ArrayAdapter<String> {

    private Context context;
    private List<String> kovanListesi;

    public KovanAdapter(Context context, List<String> kovanListesi) {
        super(context, R.layout.list_item_kovan, kovanListesi);
        this.context = context;
        this.kovanListesi = kovanListesi;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Hazırladığımız XML tasarımını (list_item_kovan) Java'ya çeviriyoruz (Inflate)
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_kovan, parent, false);
        }

        // XML'deki TextView'leri buluyoruz
        TextView tvKovanAdi = convertView.findViewById(R.id.tvKovanAdi);
        TextView tvKovanDurumu = convertView.findViewById(R.id.tvKovanDurumu);

        // İlgili sıradaki kovan adını listeden çekip ekrana yazıyoruz
        String kovanAdi = kovanListesi.get(position);
        tvKovanAdi.setText(kovanAdi);

        // Ufak bir dokunuş: Görüntü güzel olsun diye her 5 kovandan birine "Bakım Gerekiyor" uyarısı verdirdim.
        // İleride bunu kendi veritabanındaki gerçek durumlara göre (if-else ile) ayarlarsın.
        if (position % 5 == 0 && position != 0) {
            tvKovanDurumu.setText("Durum: Bakım Gerekiyor");
            tvKovanDurumu.setTextColor(Color.parseColor("#D32F2F")); // Kırmızı
        } else {
            tvKovanDurumu.setText("Durum: Sağlıklı");
            tvKovanDurumu.setTextColor(Color.parseColor("#8D6E63")); // Standart koyu kahve
        }

        return convertView;
    }
}