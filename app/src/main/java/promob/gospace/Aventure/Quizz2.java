package promob.gospace.Aventure;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import promob.gospace.MainActivity;
import promob.gospace.R;
import promob.gospace.ScoreActivity;

public class Quizz2 extends AppCompatActivity {

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

            score = score + 30;

        }


        state = (TextView) findViewById(R.id.textResultatQuestion);

        button = (Button) findViewById(R.id.activity_game_answer_suivant);

        state.setText(reponse);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(i==2){

                    // Quizz fini !

                    Intent jeusuivant = new Intent( Quizz2.this, promob.gospace.Aventure.Accelerometer.PageDebAccelerometer.class);
                    startActivity(jeusuivant);

                    SharedPreferences prefs = getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
                    int scores = prefs.getInt("key", 0); //0 is the default value

                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("key", scores + score);
                    editor.commit();

                    Log.i("DEBUG",String.valueOf(scores+ score));

                    /*
                    Intent scoreActivity = new Intent(Quizz2.this, ScoreActivity.class);
                    scoreActivity.putExtra("score",score);
                    startActivity(scoreActivity);*/

                } else {

                    Intent gameActivity = new Intent(Quizz2.this, Quizz1.class);
                    gameActivity.putExtra("i",i+1);
                    gameActivity.putExtra("scorevers1",score);
                    startActivity(gameActivity);

                }
            }
        });





    }
    @Override
    public void onBackPressed() {

        Intent gameActivity = new Intent(Quizz2.this, MainActivity.class);
        startActivity(gameActivity);
        this.onStop();
    }
}