package com.example.tictactoe;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    boolean playerTurn = false;
    boolean isPlaying = true;
    int count = 0;
    static char winner;
    char[][] playerPosition = new char[3][3];
    static String winnerName;

    TextView txt;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 3; i++) {
            Arrays.fill(playerPosition[i], ' ');
        }
        btn = findViewById(R.id.imageButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn0.setText("");
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                for (int i = 0; i < 3; i++) {
                    Arrays.fill(playerPosition[i], ' ');
                }
                isPlaying = true;
                playerTurn = false;
                winner = 0;
                count = 0;
                txt = findViewById(R.id.textView);
                txt.setText("Player X's turn");
            }
        });
        btn0 = (Button)findViewById(R.id.button0);
        btn0.setOnClickListener(this);
        btn1 = (Button)findViewById(R.id.button1);
        btn1.setOnClickListener(this);
        btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        btn3 = (Button)findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        btn4 = (Button)findViewById(R.id.button4);
        btn4.setOnClickListener(this);
        btn5 = (Button)findViewById(R.id.button5);
        btn5.setOnClickListener(this);
        btn6 = (Button)findViewById(R.id.button6);
        btn6.setOnClickListener(this);
        btn7 = (Button)findViewById(R.id.button7);
        btn7.setOnClickListener(this);
        btn8 = (Button)findViewById(R.id.button8);
        btn8.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        txt = findViewById(R.id.textView);

        if (((Button)v).getText().toString().isEmpty() && isPlaying) {
            int[] pos = getPosition((Button) v);
            if (playerTurn) {
                txt.setText("Player X's turn");
                ((Button) v).setText("O");
                playerPosition[pos[0]][pos[1]] = 'O';
                if (checkPosition(playerPosition)) winner = 'O';
            } else {
                txt.setText("Player O's turn");
                ((Button) v).setText("X");
                playerPosition[pos[0]][pos[1]] = 'X';
                if (checkPosition(playerPosition)) winner = 'X';
            }
        } else {
            return;
        }

        count++;

        if (winner != 0) {
            isPlaying = false;
            showInputDialog();
        } else if (count==9) {
            Toast.makeText(MainActivity.this, "DRAW", Toast.LENGTH_LONG).show();
        } else {
            playerTurn = !playerTurn;
        }
    }

    public int[] getPosition(Button button) {
        int[] position = new int[2];
        if (button == btn1) {
            position[1] = 1;
        } else if (button == btn2) {
            position[1] = 2;
        } else if (button == btn3) {
            position[0] = 1;
            position[1] = 0;
        } else if (button == btn4) {
            position[0] = 1;
            position[1] = 1;
        } else if (button == btn5) {
            position[0] = 1;
            position[1] = 2;
        } else if (button == btn6) {
            position[0] = 2;
            position[1] = 0;
        } else if (button == btn7) {
            position[0] = 2;
            position[1] = 1;
        } else if (button == btn8) {
            position[0] = 2;
            position[1] = 2;
        }
        return position;
    }

    boolean checkRow(char[][] position) {
        for (int i=0; i<3; i++) {
            if (position[i][0] == position[i][1] &&
                    position[i][1] == position[i][2] &&
                    position[i][0] != ' ')
                return (true);
        }
        return(false);
    }

    boolean checkColumn(char[][] position) {
        for (int i = 0; i < 3; i++) {
            if (position[0][i] == position[1][i] &&
                    position[1][i] == position[2][i] &&
                    position[0][i] != ' ')
                return true;
        }
        return(false);
    }

    boolean checkDiagonal(char[][] position) {
        if (position[0][0] == position[1][1] && 
                position[1][1] == position[2][2] && 
                position[0][0] != ' ')
            return(true);

        if (position[0][2] == position[1][1] &&
                position[1][1] == position[2][0] &&
                position[0][2] != ' ')
            return(true);
        return(false);
    }

    private boolean checkPosition(char[][] position) {
        if (checkRow(position) || checkColumn(position) || checkDiagonal(position)) return true;
        return false;
    }

    public void showInputDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter your name");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                winnerName = input.getText().toString();
                showDialog();
            }
        });
        builder.show();
    }

    public void showDialog(){
        WinnerDialog dialog = new WinnerDialog();
        dialog.show(getSupportFragmentManager(),"");
    }
}
