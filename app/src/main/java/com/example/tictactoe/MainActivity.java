package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    boolean playerTurn = false;
    boolean winner = false;
    TextView txt;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    ImageButton btn;
    int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (ImageButton)findViewById(R.id.imageButton);
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
        txt = (TextView) findViewById(R.id.textView);
        if(playerTurn){
            txt.setText("Player O's turn");
            ((Button)v).setText("O");
        }else{
            txt.setText("Player X's turn");
            ((Button)v).setText("X");
        }
        count++;
        if(win()){
            //alertdialog
            winner = win();
            showDialog();
        }else if(count==9){
            count=0;
            Toast.makeText(MainActivity.this, "DRAW", Toast.LENGTH_LONG).show();
        }else{
            playerTurn = !playerTurn;
        }


    }

    public boolean win(){
        //check if player X or player O is a winner
        //return true if player O win, return false if player X win.
        return false;
    }
    public void showDialog(){
        WinnerDialog dialog = new WinnerDialog();
        dialog.show(getSupportFragmentManager(),"");
    }


}
