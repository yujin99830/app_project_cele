package com.example.cele;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class login extends AppCompatActivity {
    TextView sign;
    Button llogin;

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //회원가입 버튼
        sign = findViewById(R.id.signin);

        //회원가입 버튼 클릭시, 회원가입 페이지로 이동
        sign.setOnClickListener(v -> {
            Intent intent = new Intent(this, signup.class);
            startActivity(intent);
        });

        llogin = findViewById(R.id.loginbutton);

        //로그인 버튼
        llogin.setOnClickListener(v -> {
            Intent intent = new Intent(this,bluetooth.class);
            startActivity(intent);
        });
    }
}