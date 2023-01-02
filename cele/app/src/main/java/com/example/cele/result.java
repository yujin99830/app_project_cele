package com.example.cele;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class result extends AppCompatActivity {

    public String setDate = null;
    public String str = null;
    public CalendarView calView;
    public Button b_Cha, b_Del, b_Save;
    public TextView diaryTextView, textView1, textView2, textView3,textView4, back, main;
    public EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent1 = getIntent(); //전달할 데이터를 받을 Intent
        Intent intent2 = getIntent();
        //text 키값으로 데이터를 받는다. String을 받아야 하므로 getStringExtra()를 사용함
        String text1 = intent1.getStringExtra("text0");
        String text2 = intent2.getStringExtra("text");

        textView4 = findViewById(R.id.textView6);
        textView4.setText(text1);
        textView3 = findViewById(R.id.textView3);
        textView3.setText(text2);


        calView = findViewById(R.id.calView);
        diaryTextView = findViewById(R.id.diaryTextView);
        b_Save = findViewById(R.id.b_Save);
        b_Del = findViewById(R.id.b_Del);
        b_Cha = findViewById(R.id.b_Cha);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        back = findViewById(R.id.back);
        main = findViewById(R.id.main);
        editText = findViewById(R.id.EditText);

        back.setOnClickListener(v -> onBackPressed() );

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
            {
                diaryTextView.setVisibility(View.VISIBLE);
                b_Save.setVisibility(View.VISIBLE);
                editText.setVisibility(View.VISIBLE);
                textView1.setVisibility(View.INVISIBLE);
                b_Cha.setVisibility(View.INVISIBLE);
                b_Del.setVisibility(View.INVISIBLE);
                diaryTextView.setText(String.format("%d / %d / %d", year, month + 1, dayOfMonth));
                editText.setText("");
                checkDay(year, month, dayOfMonth);
            }
        });
        b_Save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                saveDiary(setDate);
                str = editText.getText().toString();
                textView1.setText(str);
                b_Save.setVisibility(View.INVISIBLE);
                b_Save.setVisibility(View.VISIBLE);
                b_Del.setVisibility(View.VISIBLE);
                editText.setVisibility(View.INVISIBLE);
                textView1.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.INVISIBLE);
                textView4.setVisibility(View.INVISIBLE);

            }
        });

        main.setOnClickListener(v -> {
            Intent intent = new Intent(this, check.class);
            startActivity(intent);
        });

    }

    public void checkDay(int cal_Year, int cal_Month, int cal_Day)
    {
        setDate = "" + cal_Year + "-" + (cal_Month + 1) + "" + "-" + cal_Day + ".txt";
        FileInputStream fis;

        try
        {
            fis = openFileInput(setDate);

            byte[] fileData = new byte[fis.available()];
            fis.read(fileData);
            fis.close();

            str = new String(fileData);

            editText.setVisibility(View.INVISIBLE);
            textView1.setVisibility(View.VISIBLE);
            textView1.setText(str);
            b_Save.setVisibility(View.INVISIBLE);
            b_Cha.setVisibility(View.VISIBLE);
            b_Del.setVisibility(View.VISIBLE);

            b_Cha.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    editText.setVisibility(View.VISIBLE);
                    textView1.setVisibility(View.INVISIBLE);
                    editText.setText(str);

                    b_Save.setVisibility(View.VISIBLE);
                    b_Cha.setVisibility(View.INVISIBLE);
                    b_Del.setVisibility(View.INVISIBLE);
                    textView3.setVisibility(View.VISIBLE);
                    textView4.setVisibility(View.VISIBLE);
                    textView1.setText(editText.getText());
                }

            });
            b_Del.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    textView1.setVisibility(View.INVISIBLE);
                    editText.setText("");
                    editText.setVisibility(View.VISIBLE);
                    b_Save.setVisibility(View.VISIBLE);
                    b_Cha.setVisibility(View.INVISIBLE);
                    b_Del.setVisibility(View.INVISIBLE);
                    textView3.setVisibility(View.VISIBLE);
                    textView4.setVisibility(View.VISIBLE);
                    removeDiary(setDate);
                }
            });
            if (textView1.getText() == null)
            {
                textView1.setVisibility(View.INVISIBLE);
                diaryTextView.setVisibility(View.VISIBLE);
                b_Save.setVisibility(View.VISIBLE);
                b_Cha.setVisibility(View.INVISIBLE);
                b_Del.setVisibility(View.INVISIBLE);
                editText.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                textView4.setVisibility(View.VISIBLE);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @SuppressLint("WrongConstant")
    public void removeDiary(String setDate)
    {
        FileOutputStream fos;
        try
        {
            fos = openFileOutput(setDate, MODE_NO_LOCALIZED_COLLATORS);
            String content = "";
            fos.write((content).getBytes());
            fos.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @SuppressLint("WrongConstant")
    public void saveDiary(String setDate)
    {
        FileOutputStream fos;
        try
        {
            fos = openFileOutput(setDate, MODE_NO_LOCALIZED_COLLATORS);
            String content = editText.getText().toString();
            fos.write((content).getBytes());
            fos.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}