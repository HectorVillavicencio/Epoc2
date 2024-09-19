package com.example.epoc2.evaluator;

import android.widget.Toast;

import com.example.epoc2.MainActivity;

public class TieneNull {

    private MainActivity mainActivity;

    public TieneNull(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    public void tieneNull(String string, String frase){
        //Verifica si no completaste alguna celda
        if (string.length() == 0 ) {
            //Aca esta la advertencia si esta en falta.
            Toast.makeText(this.mainActivity, frase, Toast.LENGTH_LONG).show();
        }
    }

}
