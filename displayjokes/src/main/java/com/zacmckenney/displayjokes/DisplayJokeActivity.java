package com.zacmckenney.displayjokes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Zac on 7/18/16.
 */
public class DisplayJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String jokeForDisplay = getIntent().getStringExtra("JOKE_EXTRA");
        setContentView(R.layout.display_joke_activity);


        TextView jokeTextview = (TextView) findViewById(R.id.joke_textview);
        jokeTextview.setText(jokeForDisplay);

    }
}
