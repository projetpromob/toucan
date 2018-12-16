package promob.gospace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import promob.gospace.Aventure.PageDeb;
import promob.gospace.Aventure.Quizz1;

public class MainActivity extends AppCompatActivity {

    private TextView mGreetingText;
    private EditText mNameInput;
    //private Button mPlayButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGreetingText = (TextView) findViewById(R.id.activity_main_greeting_txt);
        mNameInput = (EditText) findViewById(R.id.activity_main_name_input);
        //mPlayButton = (Button) findViewById(R.id.activity_main_play_btn);


        //mPlayButton.setEnabled(false);

        /*
        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This is where we'll check the user input
                mPlayButton.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }


        });
        */

        /*mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
            }
        });*/
    }


    public void sendSolo(View view){
        Intent startNewActivity = new Intent(this, ChoixJoueurSolo.class );
        startActivity(startNewActivity);
    }

    public void sendMulti(View view){
        Intent startNewActivity = new Intent(this, PageDeb.class );
        startActivity(startNewActivity);
    }

    public void sendMorpion(View view){
        Intent startNewActivity = new Intent(this, Morpion.class);
        startActivity(startNewActivity);
    }
}
