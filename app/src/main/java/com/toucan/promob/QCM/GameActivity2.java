package com.toucan.promob.QCM;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.toucan.promob.R;
import com.toucan.promob.ScoreActivity;

public class GameActivity2 extends AppCompatActivity {

    private Button button;
    private TextView state;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_answer);

        Intent callingIntent = getIntent();
        String reponse = callingIntent.getStringExtra("answer");
        final int i = callingIntent.getIntExtra("i",0);
        score = callingIntent.getIntExtra("scorevers2",0);

        if(reponse.equals("Bonne réponse")){

            score = score + 1;

        }


        state = (TextView) findViewById(R.id.textResultatQuestion);

        button = (Button) findViewById(R.id.activity_game_answer_suivant);

        state.setText(reponse);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(i==2){

                    Intent scoreActivity = new Intent(GameActivity2.this, ScoreActivity.class);
                    scoreActivity.putExtra("score",score);
                    startActivity(scoreActivity);

                } else {

                    Intent gameActivity = new Intent(GameActivity2.this, GameActivity.class);
                    gameActivity.putExtra("i",i+1);
                    gameActivity.putExtra("scorevers1",score);
                    startActivity(gameActivity);

                }
            }
        });





    }
}
