package com.example.epoc2.evaluator;

import android.widget.TextView;
public class FraseHandler {

    private Frase frase;
    private CalculatorCigarretesAndAnios calcular;

    public FraseHandler(Frase frase, CalculatorCigarretesAndAnios calcular) {
        this.frase = frase;
        this.calcular = calcular;
    }

    public void generarFrase(int valor1, int valor2, TextView textView2) {
        double resultado = calcular.calcula(valor1, valor2);
        String fraseResultado = frase.frase(resultado);
        textView2.setText(fraseResultado);
    }
}