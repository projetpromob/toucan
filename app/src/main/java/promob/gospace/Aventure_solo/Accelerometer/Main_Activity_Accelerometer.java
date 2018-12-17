package promob.gospace.Aventure_solo.Accelerometer;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import promob.gospace.Jeu_Attaque.DeroulementJeuAttaque;
import promob.gospace.MainActivity;

public class Main_Activity_Accelerometer extends Activity {


    // Identifiant de la boîte de dialogue de victoire
    public static final int VICTORY_DIALOG = 0;
    // Identifiant de la boîte de dialogue de défaite
    public static final int DEFEAT_DIALOG = 1;

    private long chrono_debut;
    private long chrono_fin;

    private float time;

    // Le moteur graphique du jeu
    private Moteur_Graphique mView = null;
    // Le moteur physique du jeu
    private Moteur_Physique mEngine = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fusee b = new Fusee();

        mView = new Moteur_Graphique(this);
        mView.setFusee(b);

        mEngine = new Moteur_Physique(this);

        mEngine.setFusee(b);

        setContentView(mView);

        List<Planete> mList = mEngine.create_game();
        mView.setPlanetes(mList);

        chrono_debut = new java.util.Date().getTime();



    }

    @Override
    protected void onResume() {
        super.onResume();
        chrono_debut = new java.util.Date().getTime();

        mEngine.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mEngine.stop();
    }

    @Override
    public Dialog onCreateDialog (int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        chrono_fin = new java.util.Date().getTime() ;
        time = chrono_fin - chrono_debut;

        float result_time = time/1000;

        Integer score_time = (int) (long) ((1/result_time)*100);

        final Integer final_time = (score_time * score_time)*2 ;

        /*
        Intent gameOverIntent = new Intent(getContext() , GameOverActivity.class);
        gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        // Envoyer final_time
        gameOverIntent.putExtra("scoreRecupA", final_time);
        */


        Log.i("DEBUG", String.valueOf(score_time));



        switch(id) {
            case VICTORY_DIALOG:
                                // L'utilisateur peut recommencer s'il le veut

                                SharedPreferences prefs = getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
                                int scores = prefs.getInt("key", 0); //0 is the default value

                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putInt("key", scores + final_time);
                                editor.commit();
                                Log.i("DEBUG",String.valueOf(scores+ final_time));


                                //Lancer le jeu suivant :
                                Intent jeusuivant2 = new Intent(Main_Activity_Accelerometer.this, promob.gospace.Aventure_solo.Jeu_touch.PageDebSoucoupe.class);
                                startActivity(jeusuivant2);

                                /*
                                Intent gameActivity = new Intent(Main_Activity_Accelerometer.this, GameOverActivity_Acce.class);
                                gameActivity.putExtra("scoreRecupA",final_time);
                                startActivity(gameActivity);*/


                break;

            case DEFEAT_DIALOG:
                builder.setCancelable(false)
                        .setMessage("Vous avez explosé votre fusée")
                        .setTitle(" Perdu !")
                        .setNeutralButton("Recommencer", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mEngine.reset();
                                mEngine.resume();
                            }
                        });
        }
        return builder.create();
    }

    @Override
    public void onPrepareDialog (int id, Dialog box) {
        // A chaque fois qu'une boîte de dialogue est lancée, on arrête le moteur physique

        mEngine.stop();
    }

    @Override
    public void onBackPressed() {

        Intent gameActivity = new Intent(Main_Activity_Accelerometer.this, MainActivity.class);
        startActivity(gameActivity);
    }
}