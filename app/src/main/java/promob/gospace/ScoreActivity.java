package promob.gospace;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import promob.gospace.Jeu_Attaque.DeroulementJeuAttaque;
import promob.gospace.QCM.GameActivity;

public class ScoreActivity extends AppCompatActivity {

    private int score;
    private Button Rejouer;
    private Button Change;
    private TextView DisplayScore;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        mediaPlayer = MediaPlayer.create(this, R.raw.musover);
        mediaPlayer.start();

        Rejouer = (Button) findViewById(R.id.rejouer_btn);
        Change = (Button) findViewById(R.id.changer_btn);
        DisplayScore = (TextView) findViewById(R.id.displayScore);

        Intent callingIntent = getIntent();
        score = callingIntent.getIntExtra("score",0);

        DisplayScore.setText("Score : " + Integer.toString(score));

        Rejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                Intent Main = new Intent(ScoreActivity.this, GameActivity.class);
                Main.putExtra("best",score);
                startActivity(Main);
            }
        });

        Change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                Intent Main = new Intent(ScoreActivity.this, ChoixJoueurSolo.class);
                Main.putExtra("best",score);
                startActivity(Main);
            }
        });
    }

    @Override
    public void onBackPressed() {

        mediaPlayer.stop();
        Intent gameActivity = new Intent(ScoreActivity.this, MainActivity.class);
        startActivity(gameActivity);
    }

}