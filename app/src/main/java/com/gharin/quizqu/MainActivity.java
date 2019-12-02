package com.gharin.quizqu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView pertanyaan;
    RadioGroup rg;
    RadioButton pilihanA, pilihanB, pilihanC, pilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;


    String[] pertanyaan_kuis = new String[]{
            "1. Ibu Kota NEgara kesatuan republik indonesia adalah",
            "2. Presidan pertama di indonesia adalah",
            "3. lambang negara indonesia adalah",
            "4. lagu ke bangsaan indonesia adalah",
            "5. bendara negara indonesia adalah"
    };
    String[] jawaban_kuis = new String[]{
            "Bandung", "Jakarta", "Makasar", "marauke",
            "Soekarno", "Soeharto", "Habiebie", "Jokowi dodo",
            "Elang merah", "harimau", "komodo", "garuda pancasila",
            "Indonesia merdeka", "Majulah indonesiaku", "Indonesia raya", "bineka tunggal ika",
            "Putih abu-abu", "Merah putih", "merah putih biru", "ungu orange",
    };
    String[] jawaban_benar = new String[]{
            "Jakarta",
            "Soekarno",
            "garuda pancasila",
            "Indonesia raya",
            "Merah putih"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.radio_group);
        pertanyaan = findViewById(R.id.pertanyaan);
        pilihanA = findViewById(R.id.pilihanA);
        pilihanB = findViewById(R.id.pilihanB);
        pilihanC = findViewById(R.id.pilihanC);
        pilihanD = findViewById(R.id.pilihanD);

        pertanyaan.setText(pertanyaan_kuis[nomor]);
        pilihanA.setText(jawaban_kuis[0]);
        pilihanB.setText(jawaban_kuis[1]);
        pilihanC.setText(jawaban_kuis[2]);
        pilihanD.setText(jawaban_kuis[3]);
    }

    public void next(View view) {
        if (pilihanA.isChecked() || pilihanB.isChecked() || pilihanC.isChecked() || pilihanD.isChecked()) {
            RadioButton jawaban_user = findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;

            nomor++;
            if (nomor < pertanyaan_kuis.length) {
                pertanyaan.setText(pertanyaan_kuis[nomor]);
                pilihanA.setText(jawaban_kuis[(nomor * 4) + 0]);
                pilihanB.setText(jawaban_kuis[(nomor * 4) + 1]);
                pilihanC.setText(jawaban_kuis[(nomor * 4) + 2]);
                pilihanD.setText(jawaban_kuis[(nomor * 4) + 3]);


            } else {
                hasil = benar * 20;

                startActivity(new Intent(getApplicationContext(), HasilKuis.class));

            }
        }
        else {
            Toast.makeText(this, "Pilih Jawban Dulu", Toast.LENGTH_SHORT).show();
        }
    }
}
