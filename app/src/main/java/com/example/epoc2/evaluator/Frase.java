package com.example.epoc2.evaluator;

public class Frase {
    public String frase(double resultado) {
        if (resultado < 10) {
            return ("Bien");
        } else if (resultado >= 10 && resultado < 20) {
            return ("Elevado");
        } else if (resultado >= 21 && resultado <= 40) {
            return ("Alto");
        } else {
            return ("Muy Alto");
        }
    }
}
