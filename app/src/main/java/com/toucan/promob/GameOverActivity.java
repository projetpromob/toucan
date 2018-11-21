package com.toucan.promob;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {


    private Button Rejouer;
    private TextView DisplayScore;
    private String score;
    private Button Change;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);


        // Recuperation du score :
        score = getIntent().getExtras().get("scoreRecup").toString();

        Rejouer = (Button) findViewById(R.id.rejouer_btn);
        Change = (Button) findViewById(R.id.changer_btn);
        DisplayScore = (TextView) findViewById(R.id.displayScore);

        Rejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent mainIntent = new Intent(GameOverActivity.this , LancementJeuSoucoupe.class);
                startActivity(mainIntent);

            }
        });

        Change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent mainIntent = new Intent(GameOverActivity.this , ChoixJoueurSolo.class);
                startActivity(mainIntent);

            }
        });



        //Affichage du score :
        DisplayScore.setText("Score : " + score);

    }
}
