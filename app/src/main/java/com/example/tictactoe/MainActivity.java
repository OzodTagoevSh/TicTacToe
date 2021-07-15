package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //gamer = 0 : O; gamer = 1 : X
    int[] gameStatus = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    int gamer = 0;
    boolean gameActive = true;

    public void click(View view) {
        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if(gameStatus[tappedCounter] == 2 && gameActive) {
            gameStatus[tappedCounter] = gamer;
            counter.setTranslationY(-1500);
            if (gamer == 0) {
                counter.setImageResource(R.drawable.o);
                gamer = 1;
            } else {
                counter.setImageResource(R.drawable.x);
                gamer = 0;
            }
            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
        }

        Button buttonPlayAgain = findViewById(R.id.buttonPlayAgain);
        TextView winnerTextView = findViewById(R.id.winnerTextView);
        
        for(int[] winningPosition: winningPositions) {
            if(gameStatus[winningPosition[0]] == gameStatus[winningPosition[1]] && gameStatus[winningPosition[1]] == gameStatus[winningPosition[2]]
                    && gameStatus[winningPosition[0]] != 2) {

                gameActive = false;
                String message = "";
                if(gamer == 0) {
                    message = "X";
                } else {
                    message = "O";
                }
    
                winnerTextView.setText(message + " has won!");
                buttonPlayAgain.setVisibility(View.VISIBLE);
                winnerTextView.setVisibility(View.VISIBLE);

            }
        }
        
        int full = 0;
        for(int i = 0; i < gameStatus.length; i++) {
            if(gameStatus[i] != 2) full++;
        }
        
        if(full == 9) {
            winnerTextView.setText("Draw game!");
            buttonPlayAgain.setVisibility(View.VISIBLE);
            winnerTextView.setVisibility(View.VISIBLE);
        }
    }

    public void playAgain(View view) {

        Button buttonPlayAgain = findViewById(R.id.buttonPlayAgain);
        TextView winnerTextView = findViewById(R.id.winnerTextView);
        buttonPlayAgain.setVisibility(View.INVISIBLE);
        winnerTextView.setVisibility(View.INVISIBLE);
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for(int i = 0; i < gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }

        for(int i = 0; i < gameStatus.length; i++) {
            gameStatus[i] = 2;
        }
        gamer = 0;
        gameActive = true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
