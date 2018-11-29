package promob.gospace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private int score;
    private TextView textscore;
    private Button retry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        retry = (Button) findViewById(R.id.activity_score_button_recommencer);

        Intent callingIntent = getIntent();
        score = callingIntent.getIntExtra("score",0);

        textscore = (TextView) findViewById(R.id.activity_score_button);

        textscore.setText(Integer.toString(score));

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Main = new Intent(ScoreActivity.this, MainActivity.class);
                Main.putExtra("best",score);
                startActivity(Main);
            }
        });
    }
}