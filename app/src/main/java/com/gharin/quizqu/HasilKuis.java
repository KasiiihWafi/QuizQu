package com.gharin.quizqu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HasilKuis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_kuis);

        TextView hasil = findViewById(R.id.hasil);
        TextView nilai = findViewById(R.id.nilai);

        hasil.setText("Jawaban Benar : " +MainActivity.benar+"\nJawaban Salah : "+ MainActivity.salah);
        nilai.setText(""+MainActivity.hasil);
    }

    public void ulangi(View view) {
        finish();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
