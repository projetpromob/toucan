package com.toucan.promob.QCM;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.toucan.promob.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GameActivity extends AppCompatActivity {

    List <List<String>> questionreponse = new ArrayList();

    private int score;

    private TextView question,resultat;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private String answerstate;
    private int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        List <String> question1 = new ArrayList();
        question1.add("Quel est le record de vitesse d'une fusée");
        question1.add("40 000 km/h");
        question1.add("30 000 km/h");
        question1.add("50 000 km/h");
        question1.add("20 000 km/h");
        question1.add("40 000 km/h");


        questionreponse.add(question1);

        List <String> question2 = new ArrayList();
        question2.add("Quelle est la distance la plus grande parcourue par une fusée ");
        question2.add("400 000 km");
        question2.add("1 000 000 km");
        question2.add("2 000 000 km");
        question2.add("100 000 km");
        question2.add("400 000 km");

        questionreponse.add(question2);

        List <String> question3 = new ArrayList ();
        question3.add("Qui est le dernier français à être aller dans l'espace");
        question3.add("Thomas PESQUET");
        question3.add("Jean-Loup CHRETIEN");
        question3.add("Pierre HAIGNERE");
        question3.add("Philippe PERRIN");
        question3.add("Thomas PESQUET");

        questionreponse.add(question3);

        i = 0;

        try {
            Intent callingIntent = getIntent();
            i = callingIntent.getIntExtra("i",0);

        } catch(Exception e){
            //This catch block catches all the exceptions
        }

        //System.out.println("%%%%%%%%%%%%%%%" + i );

        try{

            Intent callingIntent = getIntent();
            score = callingIntent.getIntExtra("scorevers1",0);

        } catch (Exception e){

        }

        final String answer = questionreponse.get(i).get(5);

        final TextView question = (TextView) findViewById(R.id.activity_game_question_text);
        final Button button1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        final Button button2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        final Button button3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        final Button button4 = (Button) findViewById(R.id.activity_game_answer4_btn);

        question.setText(questionreponse.get(i).get(0));

        questionreponse.get(i).remove(0);
        questionreponse.get(i).remove(4);

        Collections.shuffle(questionreponse.get(i));

        button1.setText(questionreponse.get(i).get(0));
        button2.setText(questionreponse.get(i).get(1));
        button3.setText(questionreponse.get(i).get(2));
        button4.setText(questionreponse.get(i).get(3));

        questionreponse.remove(i);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(button1.getText()==answer){

                    answerstate = "Bonne réponse";

                }else {

                    answerstate = "Mauvaise réponse";

                }


                Intent gameActivity = new Intent(GameActivity.this, GameActivity2.class);
                gameActivity.putExtra("answer",answerstate);
                gameActivity.putExtra("i",i);
                gameActivity.putExtra("scorevers2",score);
                startActivity(gameActivity);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(button2.getText()==answer){

                    answerstate = "Bonne réponse";

                }else {

                    answerstate = "Mauvaise réponse";

                }

                Intent gameActivity = new Intent(GameActivity.this, GameActivity2.class);
                gameActivity.putExtra("answer",answerstate);
                gameActivity.putExtra("i",i);
                gameActivity.putExtra("scorevers2",score);
                startActivity(gameActivity);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(button3.getText()==answer){

                    answerstate = "Bonne réponse";

                }else {

                    answerstate = "Mauvaise réponse";

                }

                Intent gameActivity = new Intent(GameActivity.this, GameActivity2.class);
                gameActivity.putExtra("answer",answerstate);
                gameActivity.putExtra("i",i);
                gameActivity.putExtra("scorevers2",score);
                startActivity(gameActivity);

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(button4.getText()==answer){

                    answerstate = "Bonne réponse";

                }else {

                    answerstate = "Mauvaise réponse";

                }

                Intent gameActivity = new Intent(GameActivity.this, GameActivity2.class);
                gameActivity.putExtra("answer",answerstate);
                gameActivity.putExtra("i",i);
                gameActivity.putExtra("scorevers2",score);
                startActivity(gameActivity);

            }
        });


    }
}
