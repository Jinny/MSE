package com.example.tictactoe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;

import static com.example.tictactoe.MainActivity.winner;
import static com.example.tictactoe.MainActivity.winnerName;

public class WinnerDialog extends AppCompatDialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if(winner == 'O')
            builder.setMessage("Player O Win");
        else
            builder.setMessage("Player X Win");
        builder.setTitle("Congratulations, " + winnerName + "!").setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {}
        });
        return builder.create();
    }
}

