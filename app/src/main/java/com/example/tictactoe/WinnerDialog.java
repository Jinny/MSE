package com.example.tictactoe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;


// Idk whether this code is working or not
public class WinnerDialog extends AppCompatDialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        MainActivity main = new MainActivity();
        if(main.winner)
        builder.setMessage("Player O Win");
        else
            builder.setMessage("Player X Win");
        builder.setTitle("Congratulations!").setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        return builder.create();
    }
}
