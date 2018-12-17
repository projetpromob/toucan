package promob.gospace;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Credit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

    }


    @Override
    public void onBackPressed() {

        Intent gameActivity = new Intent(Credit.this, MainActivity.class);
        startActivity(gameActivity);
    }
}
