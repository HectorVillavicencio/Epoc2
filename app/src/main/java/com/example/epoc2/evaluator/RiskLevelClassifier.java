package com.example.epoc2.evaluator;

import java.util.NavigableMap;
import java.util.TreeMap;

public class RiskLevelClassifier {

    private final NavigableMap<Double, String> riskLevels = new TreeMap<>();

    public RiskLevelClassifier() {
        // Asignar niveles de riesgo
        riskLevels.put(10.0, "Bajo");
        riskLevels.put(20.0, "Elevado");
        riskLevels.put(40.0, "Alto");
        riskLevels.put(Double.MAX_VALUE, "Muy Alto"); // Para valores mayores a 40
    }

    public String riskLevel(double resultado) {
        // Retornar el valor adecuado para el rango
        return riskLevels.ceilingEntry(resultado).getValue();
    }

}
