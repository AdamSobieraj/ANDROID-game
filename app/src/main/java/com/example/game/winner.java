package com.example.game;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class winner extends AppCompatActivity {

    private static final String WIN_MESSAGE = "Winner";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_winner);

        TextView winner = findViewById(R.id.smg);

        winner.setText(WIN_MESSAGE);

    }
}