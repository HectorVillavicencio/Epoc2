package com.example.epoc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private EditText textNroCig, textNroAnio;
    private TextView textView, textView2;


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
    }

    //Verifica si estan todos los valores, si no lanza una alerta
    public void verificar(View view){
        String cig = textNroCig.getText().toString();
        String anio = textNroAnio.getText().toString();

        //notificacion de error
        this.tieneNull(cig, "Dale, deci cuanto fumas por dia capo");
        this.tieneNull(anio, "Deci hace cuanto fumas, porque no te hago un carajo así");

        this.calculaSiTieneTodosLosDatos(cig,anio);

    }

    private void calculaSiTieneTodosLosDatos(String cig, String anio) {

        if(cig.length() != 0 && anio.length() !=0){
            this.calcular();
            this.frase();
        }
    }

    // hace el calculo dado
    public void calcular(){
        int valor1 = Integer.parseInt(textNroCig.getText().toString());
        int valor2 = Integer.parseInt(textNroAnio.getText().toString());

        textView.setText(String.valueOf(calcula(valor1,valor2)));

    }

    // resuelve el calulo
    private float calcula(int v1, int v2){
        return (v1 * v2) / 20;
    }

    public void tieneNull(String string, String frase) {
        //Verifica si no completaste alguna celda
        if (string.length() == 0) {
            //Aca esta la advertencia si esta en falta.
            Toast.makeText(this, frase, Toast.LENGTH_LONG).show();
        }
    }

    public void frase(){
        int valor1 = Integer.parseInt(textNroCig.getText().toString());
        int valor2 = Integer.parseInt(textNroAnio.getText().toString());
        // Verificar el rango del resultado y mostrar el mensaje apropiado
        if (this.calcula(valor1 ,valor2) < 10) {
            textView2.setText(String.valueOf("¡Bien! Tu salud es importante :)"));
        } else if (calcula(valor1 ,valor2) >= 10 && calcula(valor1 ,valor2) < 20) {
            textView2.setText(String.valueOf("Elevado. Empeza a bajar los cigarrillos."));
        } else if (calcula(valor1 ,valor2) >= 21 && calcula(valor1 ,valor2) <= 40) {
            textView2.setText(String.valueOf("Peligroso. Encerio, estas jodido, reduci el consumo."));
        } else {
            textView2.setText(String.valueOf("Muy mal. Anda aprendiendo a tocar el arpa o baja el consumo"));
        }
    }

}