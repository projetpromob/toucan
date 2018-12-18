package promob.gospace.Multi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import promob.gospace.ChoixJoueurSolo;
import promob.gospace.MainActivity;
import promob.gospace.QCM.GameActivity;
import promob.gospace.R;

public class PageFin extends AppCompatActivity {

    private Button Acceuil;
    private TextView DisplayScore;
    private String gagnant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vainqueur);

        Acceuil = (Button) findViewById(R.id.acceuil_btn);
        DisplayScore = (TextView) findViewById(R.id.displayScore);

        Intent callingIntent = getIntent();
        gagnant = callingIntent.getStringExtra("res");

        DisplayScore.setText(gagnant);

        Acceuil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Main = new Intent(PageFin.this, MainActivity.class);
                startActivity(Main);
            }
        });

    }

    @Override
    public void onBackPressed() {

        Intent gameActivity = new Intent(PageFin.this, MainActivity.class);
        startActivity(gameActivity);
    }
}