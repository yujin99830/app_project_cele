package com.example.cele;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class strength extends AppCompatActivity {

    TextView textView,explain;
    Button checkbutton;
    String bpm;
    int seek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strength);

        textView = findViewById(R.id.devicelist);
        explain = findViewById(R.id.explain);
        checkbutton = findViewById(R.id.checkbutton);

        Intent Bintent=getIntent();
        bpm=Bintent.getStringExtra("bpm");

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                seek = seekBar.getProgress() + 50;
                String streng = textView.getText().toString();

                textView.setText(String.format("%d", seek));
                checkbutton.setOnClickListener(v -> {
                    Intent intent = new Intent(strength.this, check.class);
                    intent.putExtra("bpm",bpm);
                    intent.putExtra("strength",streng);

                    startActivity(intent);
                });
            }
        });

        explain.setOnClickListener(v -> {
            Intent intent = new Intent(this, explain.class);
            startActivity(intent);
        });




    }
}