package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class game extends AppCompatActivity {

    private static final String INITIAL_VALUE = "0";
    private static final String WELCOME_MESSAGE = "Good luck ";
    private static final String END_MESSAGE = "Adding bordered";
    private static final int SCORE_END = 22;
    private static final int WIN_SCORE = 22;

    private TextView GameMessage;
    private TextView score;
    private Button GameBTN;
    private Button buttonReset;
    private boolean stopGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);

        Intent thisIntent = getIntent();//pobranie z poprzedniego widoku
        String username = thisIntent.getStringExtra("username");
        String surname = thisIntent.getStringExtra("surname");

        GameMessage = findViewById(R.id.GameMessage);
        score = findViewById(R.id.score);
        GameBTN = findViewById(R.id.GameBTN);
        buttonReset = findViewById(R.id.buttonReset);

        score.setText(INITIAL_VALUE);
        GameMessage.setText(String.format("%s%s - %s", WELCOME_MESSAGE, username, surname));

        GameBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!stopGame) {
                    addOne();
                }
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });

    }

    public void addOne() {
        int scoreVal = Integer.parseInt(score.getText().toString());
        scoreVal += 1;

        if (scoreVal == SCORE_END && !stopGame) {
            Toast.makeText(this, END_MESSAGE, Toast.LENGTH_SHORT).show();
            stopGame = true;
        } else {
            score.setText(String.valueOf(scoreVal));
        }

        if (scoreVal > WIN_SCORE) {
            stopGame = true;
            Intent winner = new Intent(game.this, winner.class);
            startActivity(winner);
        }

    }

    public void reset() {

        if (!score.getText().equals(INITIAL_VALUE)) {
            score.setText(INITIAL_VALUE);
            stopGame = false;
        }
    }
}