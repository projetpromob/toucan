package promob.gospace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import promob.gospace.QCM.GameActivity;

public class ScoreActivity extends AppCompatActivity {

    private int score;
    private Button Rejouer;
    private Button Change;
    private TextView DisplayScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Rejouer = (Button) findViewById(R.id.rejouer_btn);
        Change = (Button) findViewById(R.id.changer_btn);
        DisplayScore = (TextView) findViewById(R.id.displayScore);

        Intent callingIntent = getIntent();
        score = callingIntent.getIntExtra("score",0);

        DisplayScore.setText("Score : " + Integer.toString(score));

        Rejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Main = new Intent(ScoreActivity.this, GameActivity.class);
                Main.putExtra("best",score);
                startActivity(Main);
            }
        });

        Change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Main = new Intent(ScoreActivity.this, ChoixJoueurSolo.class);
                Main.putExtra("best",score);
                startActivity(Main);
            }
        });
    }
}