package com.example.epoc2.evaluator;

import com.example.epoc2.MainActivity;
public class Frase {
    private MainActivity mainActivity;

    public String frase(double resultado) {
        if (resultado < 10) {
            return ("Bajo");
        } else if (resultado >= 10 && resultado < 20) {
            return ("Elevado");
        } else if (resultado >= 21 && resultado <= 40) {
            return ("Alto");
        } else {
            return ("Muy Alto");
        }
    }

}
