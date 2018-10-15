package com.toucan.promob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private TextView question;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        question = (TextView) findViewById(R.id.activity_game_question_text);
        button1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        button2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        button3 = (Button) findViewById(R.id.activity_game_answer1_btn);
        button4 = (Button) findViewById(R.id.activity_game_answer1_btn);
    }
}
