package promob.gospace.Jeu_Attaque;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import promob.gospace.ChoixJoueurSolo;
import promob.gospace.MainActivity;
import promob.gospace.R;

public class GameOverAttaque extends AppCompatActivity {


    private Button Rejouer;
    private TextView DisplayScore;
    private String score;
    private Button Change;

    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        mediaPlayer = MediaPlayer.create(this, R.raw.musover);
        mediaPlayer.start();


        // Recuperation du score :
        score = getIntent().getExtras().get("scoreRecup").toString();

        Rejouer = (Button) findViewById(R.id.rejouer_btn);
        Change = (Button) findViewById(R.id.changer_btn);
        DisplayScore = (TextView) findViewById(R.id.displayScore);

        Rejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.stop();
                Intent mainIntent = new Intent(GameOverAttaque.this , LancementJeuAttaque.class);
                startActivity(mainIntent);

            }
        });

        Change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.stop();
                Intent mainIntent = new Intent(GameOverAttaque.this , ChoixJoueurSolo.class);
                startActivity(mainIntent);

            }
        });



        //Affichage du score :
        DisplayScore.setText("Score : " + score);

    }

    @Override
    public void onBackPressed() {

        mediaPlayer.stop();
        Intent gameActivity = new Intent(GameOverAttaque.this, ChoixJoueurSolo.class);
        startActivity(gameActivity);
    }
}
