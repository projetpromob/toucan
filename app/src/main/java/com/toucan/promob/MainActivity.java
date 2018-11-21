package com.toucan.promob;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.toucan.promob.Accelerometer.Main_Activity_Accelerometer;

public class MainActivity extends AppCompatActivity {

    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlayButton;
    private Button mBest;
    private Button mAccelerometre;
    private int best;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGreetingText = (TextView) findViewById(R.id.activity_main_greeting_txt);
        mNameInput = (EditText) findViewById(R.id.activity_main_name_input);
        mPlayButton = (Button) findViewById(R.id.activity_main_play_btn);
        mAccelerometre = (Button) findViewById(R.id.activity_main_play_accelerometre);
        mBest = (Button) findViewById(R.id.activity_score_best);


        Intent callingIntent = getIntent();
        score = callingIntent.getIntExtra("best",0);

        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        int best = prefs.getInt("key", 0); //0 is the default value

        if(score > best) {

            prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("key", score);
            editor.commit();
            mBest.setText(Integer.toString(score));

        } else {

            mBest.setText(Integer.toString(best));

        }

        mPlayButton.setEnabled(false);

        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This is where we'll check the user input
                mPlayButton.setEnabled(s.toString().length() != 0);
                //System.out.println("%%%%%%%%%%%"+ s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }


        });

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gameActivity = new Intent(MainActivity.this, GameActivity.class);
                startActivity(gameActivity);

            }
        });

        mAccelerometre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gameActivity = new Intent(MainActivity.this, Main_Activity_Accelerometer.class);
                startActivity(gameActivity);

            }
        });


    }
}
