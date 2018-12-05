package promob.gospace.Pilotage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import promob.gospace.Jeu_touch.GameOverActivity;
import promob.gospace.R;

public class JeuPilotage extends View {

    //Tableau a deux dimensions
    //plateau[colonne][ligne]
    // 0 : case vide
    // 1 : X
    // 2 : O
    private int plateau[][] = new int[3][3];


    private ArrayList<Button> all_buttons = new ArrayList<>();
    int nombreAleatoire;

    @SuppressLint("ResourceAsColor")
    public JeuPilotage(Context context)
    {
        super(context);

        // Récuperation des boutons

        Button bt1 = (Button) findViewById(R.id.bt1);
        Button bt2 = (Button) findViewById(R.id.bt2);
        Button bt3 = (Button) findViewById(R.id.bt3);
        Button bt4 = (Button) findViewById(R.id.bt4);
        Button bt5 = (Button) findViewById(R.id.bt5);
        Button bt6 = (Button) findViewById(R.id.bt6);
        Button bt7 = (Button) findViewById(R.id.bt7);
        Button bt8 = (Button) findViewById(R.id.bt8);
        Button bt9 = (Button) findViewById(R.id.bt9);

        // Ajout des boutons dans l'ArrayList :

        all_buttons.add(bt1);
        all_buttons.add(bt2);
        all_buttons.add(bt3);
        all_buttons.add(bt4);
        all_buttons.add(bt5);
        all_buttons.add(bt6);
        all_buttons.add(bt7);
        all_buttons.add(bt8);
        all_buttons.add(bt9);

        // On retire le fond des boutons :

        for (Button bt : all_buttons) {
            bt.setBackgroundDrawable(null);
            bt.setOnClickListener((OnClickListener) this);
        }



    }

    // On change aléatoirement la couleur des boutons

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        nombreAleatoire = 1 + (int)(Math.random() * ((9 - 1) + 1));
        Change(nombreAleatoire);
    }

    public void Change(int nbAl){
        switch (nbAl) {
            case 1:
                all_buttons.get(0).setBackgroundColor(0x2FAC49);
                break;
            case 2:
                all_buttons.get(1).setBackgroundColor(0x2FAC49);
                break;
            case 3:
                all_buttons.get(2).setBackgroundColor(0x2FAC49);
                break;
            case 4:
                all_buttons.get(3).setBackgroundColor(0x2FAC49);
                break;
            case 5:
                all_buttons.get(4).setBackgroundColor(0x2FAC49);
                break;
            case 6:
                all_buttons.get(5).setBackgroundColor(0x2FAC49);
                break;
            case 7:
                all_buttons.get(6).setBackgroundColor(0x2FAC49);
                break;
            case 8:
                all_buttons.get(7).setBackgroundColor(0x2FAC49);
                break;
            case 9:
                all_buttons.get(8).setBackgroundColor(0x2FAC49);
                break;
            default:
        }


    }


    public void onClick(View v) {
        //On ne fait rien si la case cliqué n'est pas vide
        if (v.getBackground() != null)
            return;

    }
}