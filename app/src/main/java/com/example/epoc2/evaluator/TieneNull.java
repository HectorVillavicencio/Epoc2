package com.example.epoc2.evaluator;

import android.widget.Toast;

public class TieneNull {
    public void tieneNull(String string, String frase){
        //Verifica si no completaste alguna celda
        if (string.length() == 0 ) {
            //Aca esta la advertencia si esta en falta.
            Toast.makeText(this, frase, Toast.LENGTH_LONG).show();
        }
    }
}
