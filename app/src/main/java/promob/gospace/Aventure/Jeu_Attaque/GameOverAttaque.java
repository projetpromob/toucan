package promob.gospace.Aventure.Jeu_Attaque;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import promob.gospace.ChoixJoueurSolo;
import promob.gospace.Jeu_Attaque.DeroulementJeuAttaque;
import promob.gospace.MainActivity;
import promob.gospace.R;

public class GameOverAttaque extends AppCompatActivity {


    private Button Rejouer;
    private TextView DisplayScore;
    private String scoreAttaque;
    private Button Change;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);


        // Recuperation du score :
        Intent callingIntent = getIntent();
        int scoreprec = callingIntent.getIntExtra("scoreAttaque",0);

        SharedPreferences prefs = getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        int scores = prefs.getInt("key", 0); //0 is the default value

        SharedPreferences.Editor editor = prefs.edit();
        int res = scores+scoreprec;

        editor.putInt("key", res);
        editor.commit();


        Log.i("DEBUG",String.valueOf(res));


        Rejouer = (Button) findViewById(R.id.rejouer_btn);
        Change = (Button) findViewById(R.id.changer_btn);
        DisplayScore = (TextView) findViewById(R.id.displayScore);

        Rejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent mainIntent = new Intent(GameOverAttaque.this , LancementJeuAttaque.class);
                startActivity(mainIntent);

            }
        });

        Change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent mainIntent = new Intent(GameOverAttaque.this , ChoixJoueurSolo.class);
                startActivity(mainIntent);

            }
        });



        //Affichage du score :
        DisplayScore.setText("Score : " + res);

    }

    @Override
    public void onBackPressed() {

        Intent gameActivity = new Intent(GameOverAttaque.this, MainActivity.class);
        startActivity(gameActivity);
    }
}
