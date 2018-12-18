package promob.gospace;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import promob.gospace.ChoixJoueurSolo;
import promob.gospace.Jeu_Attaque.DeroulementJeuAttaque;
import promob.gospace.Morpion;
import promob.gospace.R;

public class GameOverActivityMorpion extends AppCompatActivity {


    private Button Rejouer;
    private TextView DisplayScore;
    private String gagnant;
    private Button Change;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over_morpion);

        mediaPlayer = MediaPlayer.create(this, R.raw.musover);
        mediaPlayer.start();

        gagnant = getIntent().getExtras().get("gagnant").toString();

        Rejouer = (Button) findViewById(R.id.rejouer_btn);
        Change = (Button) findViewById(R.id.changer_btn);
        DisplayScore = (TextView) findViewById(R.id.displayScore);

        Rejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.stop();
                Intent mainIntent = new Intent(GameOverActivityMorpion.this , Morpion.class);
                startActivity(mainIntent);

            }
        });

        Change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.stop();
                Intent mainIntent = new Intent(GameOverActivityMorpion.this , MainActivity.class);
                startActivity(mainIntent);

            }
        });



        //Affichage du gagant
        DisplayScore.setText(gagnant);

    }

    @Override
    public void onBackPressed() {

        Intent gameActivity = new Intent(GameOverActivityMorpion.this, MainActivity.class);
        startActivity(gameActivity);
    }
}
