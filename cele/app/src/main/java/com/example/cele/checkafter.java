package com.example.cele;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class checkafter extends AppCompatActivity {
    TextView back;
    Button result;
    EditText editText;
    TextView finish;
    String bpms;
    int bpm;
    int strength=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkafter);
        init();
        SettingListener();

        back = findViewById(R.id.back);
        result = findViewById(R.id.saveB);
        finish= findViewById(R.id.success);

        back.setOnClickListener(v -> {
            Intent intent = new Intent(this, check.class);
            startActivity(intent);
        });

    }

    private void init() {
        editText = findViewById(R.id.contextText);
        result = findViewById(R.id.saveB); //xml에서 생성한 id 매치
        Intent Bintent=getIntent();
        Intent strg = getIntent();
        bpms=Bintent.getStringExtra("bpm");
        String s = strg.getStringExtra("strength");
        strength=Integer.parseInt(s);
        editText.setText(bpm);
        bpm=Integer.parseInt(bpms);
        if(strength<60){
            if(104<=bpm){
                finish.setText("성공!");
            }
            else{
                finish.setText("실패");
            }
        }
        else if(strength>=60&&strength<70){
            if(115<=bpm){
                finish.setText("성공!");
            }
            else{
                finish.setText("실패");
            }
        }
        else if(strength>=70&&strength<80){
            if(134<=bpm){
                finish.setText("성공!");
            }
            else{
                finish.setText("실패");
            }
        }
        else if(strength>=80&&strength<90){
            if(153<=bpm){
                finish.setText("성공!");
            }
            else{
                finish.setText("실패");
            }
        }
        else if(strength>=90&&strength<100){
            if(173<=bpm){
                finish.setText("성공!");
            }
            else{
                finish.setText("실패");
            }
        }
    }

    private void SettingListener() {
        //버튼에 클릭 이벤트 적용
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editText.getText().toString(); //editText에 입력한 문자열을 얻어 온다.

                //인텐트 선언 및 정의
                Intent intent = new Intent(checkafter.this, result.class);
                //입력한 input값을 intent로 전달한다.
                intent.putExtra("text", input);
                //액티비티 이동
                startActivity(intent);
            }
        });
    }
}
