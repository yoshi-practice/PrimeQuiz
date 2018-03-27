package com.example.owner.primequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final int QUESTION_COUNT = 10;
    TextView textView;
    Random random = new Random();
    int[] questions;
    int point;
    int answerCount;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        questions = new int[QUESTION_COUNT];

        for (int i = 0; i < QUESTION_COUNT; i++) {
            int number = random.nextInt(1000);
            Log.d("Number", "Question" + number);
            questions[i] = number;
        }

        point = 0;
        answerCount = 0;

        textView.setText(questions[answerCount] + "");

        number = random.nextInt(1000);
        textView.setText(String.valueOf(number));
    }

    public void maru(View v) {
        number = random.nextInt(1000);
        textView.setText(String.valueOf(number));

        boolean answer = true;
        int number = questions[answerCount];
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                answer = false;
                break;
            }
        }
        if (answer) {
            Toast.makeText(this, "正解", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "不正解", Toast.LENGTH_SHORT).show();
        }

        if (answer) {
            point++;
            Log.d("maru", "正解;" + point);
        } else {
            Log.d("maru", "不正解");
        }
    }

        public void batsu(View v) {
            number = random.nextInt(1000);
            textView.setText(String.valueOf(number));

            boolean answer = false;
            int number = questions[answerCount];
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    answer = true;
                    break;
                }
            }
            if (answer) {
                Toast.makeText(this, "正解", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "不正解", Toast.LENGTH_SHORT).show();
            }

            if (answer) {
                point++;
                Log.d("batsu", "正解;" + point);
            } else {
                Log.d("batsu", "不正解");


        answerCount++;
        if(answerCount == QUESTION_COUNT) {
            textView.setText(point + "点");

            point = 0;
            answerCount = 0;
        } else {
            textView.setText(questions[answerCount]+"");
        }}}}