package com.example.epoc2.evaluator;

import android.widget.TextView;
public class FraseHandler {

    private RiskLevelClassifier frase;
    private Calculatehealth calcular;

    public FraseHandler(RiskLevelClassifier frase, Calculatehealth calcular) {
        this.frase = frase;
        this.calcular = calcular;
    }

    public void generatephrase(int valor1, int valor2, TextView textView2) {
        double resultado = calcular.calculatehealth(valor1, valor2);
        String fraseResultado = frase.riskLevel(resultado);
        textView2.setText(fraseResultado);
    }
}