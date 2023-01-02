package com.example.cele;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class checkbefore extends AppCompatActivity {

    TextView back, next;
    Button result;
    EditText editText;
    String bpm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbefore);
        init();
        SettingListener();

        back = findViewById(R.id.back);
        result = findViewById(R.id.saveB);
        next = findViewById(R.id.next);
        Intent Bintent=getIntent();
        bpm=Bintent.getStringExtra("bpm");
        editText.setText(bpm);

        back.setOnClickListener(v -> {
            Intent intent = new Intent(this, check.class);
            startActivity(intent);
        });
        next.setOnClickListener(v -> {
            Intent intent = new Intent(this, checkafter.class);
            startActivity(intent);
        });

    }

    private void init() {
        editText = findViewById(R.id.contextText);
        result = findViewById(R.id.saveB); //xml에서 생성한 id 매치
        Intent Bintent=getIntent();
        bpm=Bintent.getStringExtra("bpm");
        editText.setText(bpm);
    }

    private void SettingListener() {
        //버튼에 클릭 이벤트 적용
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editText.getText().toString(); //editText에 입력한 문자열을 얻어 온다.

                //인텐트 선언 및 정의
                Intent intent = new Intent(checkbefore.this, result.class);
                //입력한 input값을 intent로 전달한다.
                intent.putExtra("text0", input);
                //액티비티 이동
                startActivity(intent);
            }
        });
    }
}

