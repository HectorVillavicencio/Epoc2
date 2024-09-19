package com.example.epoc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.ekn.gruzer.gaugelibrary.HalfGauge;
import com.ekn.gruzer.gaugelibrary.Range;
import com.example.epoc2.evaluator.Frase;


import com.example.epoc2.evaluator.CalculatorCigarretesAndAnios;
import com.example.epoc2.evaluator.CalculatorCigarretesAndAnios.*;

public class MainActivity extends AppCompatActivity {
    private Frase frase = new Frase();

    private CalculatorCigarretesAndAnios calcular = new CalculatorCigarretesAndAnios();

    private EditText textNroCig, textNroAnio;
    private TextView textView, textView2;
    private HalfGauge idMedidor;
    private com.ekn.gruzer.gaugelibrary.Range Range1, Range2, Range3, Range4;
    private int SetearGrafica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textNroCig = findViewById(R.id.textNroCig);
        textNroAnio = findViewById(R.id.textNroAnio);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

        //icono en el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setIcon(R.mipmap.ic_launcher); agrega el icono al lado de la letra. Para tenerlo
        //aca empiezo ahcer el medidor
        idMedidor = findViewById(R.id.idMedidor);

        Range1 = new com.ekn.gruzer.gaugelibrary.Range();
        Range2 = new com.ekn.gruzer.gaugelibrary.Range();
        Range3 = new com.ekn.gruzer.gaugelibrary.Range();
        Range4 = new com.ekn.gruzer.gaugelibrary.Range();

        Range1.setFrom(0); Range1.setTo(10);
        Range2.setFrom(11); Range2.setTo(20);
        Range3.setFrom(21); Range3.setTo(40);
        Range4.setFrom(41); Range4.setTo(50);

        Range1.setColor(Color.GREEN);
        Range2.setColor(Color.YELLOW);
        Range3.setColor(Color.parseColor("#FFA500"));
        Range4.setColor(Color.RED);

        idMedidor.setValue(0);
        idMedidor.setMinValue(0);
        idMedidor.setMaxValue(50);

        idMedidor.addRange(Range1);
        idMedidor.addRange(Range2);
        idMedidor.addRange(Range3);
        idMedidor.addRange(Range4);


    }

    //Verifica si estan todos los valores, si no lanza una alerta
    public void verificar(View view){
        String cig = textNroCig.getText().toString();
        String anio = textNroAnio.getText().toString();

        //notificacion de error
        this.tieneNull(cig, "Falta la cantidad de cigarrillos diarios");
        this.tieneNull(anio, "Falta la cantidad de años que fumas");

        this.calculaSiTieneTodosLosDatos(cig,anio);

    }

    private void calculaSiTieneTodosLosDatos(String cig, String anio) {

        if(cig.length() != 0 && anio.length() !=0){
            this.calcular();
            this.frase();
            idMedidor.setValue(calcular.calcula(Integer.parseInt(cig),Integer.parseInt(anio)));
            this.cerrarTeclado();
        }
    }

    private void cerrarTeclado() {
        View view = this.getCurrentFocus();
        if(view != null){
            InputMethodManager inm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            inm.hideSoftInputFromWindow(view.getWindowToken(), 0 );
        }

    }

    // hace el calculo dado
    public void calcular(){
        int valor1 = Integer.parseInt(textNroCig.getText().toString());
        int valor2 = Integer.parseInt(textNroAnio.getText().toString());

        textView.setText(String.valueOf(calcular.calcula(valor1,valor2)));
    }

    // resuelve el calulo


    public void tieneNull(String string, String frase) {
        if (string.length() == 0 ) {
            //Aca esta la advertencia si esta en falta.
            Toast.makeText(this, frase, Toast.LENGTH_LONG).show();
        }
    }


    public void frase(){
        int valor1 = Integer.parseInt(textNroCig.getText().toString());
        int valor2 = Integer.parseInt(textNroAnio.getText().toString());
        double resultado = calcular.calcula(valor1 ,valor2);
        textView2.setText(String.valueOf(frase.frase(resultado)));

    }

}