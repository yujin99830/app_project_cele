package com.example.cele;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class check extends AppCompatActivity {

    ImageView before, after;
    String bpm;
    String strength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        before = findViewById(R.id.beforebutton);
        after = findViewById(R.id.afterbutton);

        Intent Bintent=getIntent();
        bpm=Bintent.getStringExtra("bpm");
        strength=Bintent.getStringExtra("strength");

        before.setOnClickListener(v -> {
            Intent intent = new Intent(this, checkbefore.class);
            intent.putExtra("bpm",bpm);
            startActivity(intent);
        });

        after.setOnClickListener(v -> {
            Intent intent = new Intent(check.this, checkafter.class);
            intent.putExtra("bpm",bpm);
            intent.putExtra("strength",strength);
            Toast.makeText(getApplicationContext(), "strength"+strength+" "+bpm, Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });


    }
}