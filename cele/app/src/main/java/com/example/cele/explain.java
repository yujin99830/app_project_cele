package com.example.cele;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class explain extends AppCompatActivity {

    TextView back1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explain);

        //뒤로 가기 버튼
        back1 = findViewById(R.id.back);
        back1.setOnClickListener(v -> onBackPressed() );
    }
}