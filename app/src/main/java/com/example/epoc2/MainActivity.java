package com.example.epoc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ekn.gruzer.gaugelibrary.HalfGauge;
import com.example.epoc2.evaluator.Calculatehealth;
import com.example.epoc2.evaluator.RiskLevelClassifier;
import com.example.epoc2.evaluator.FraseHandler;
import com.example.epoc2.evaluator.TieneNull;
import com.example.epoc2.keyboard.KeyboardManager;
import com.example.epoc2.popup.PopupHelper;

public class MainActivity extends AppCompatActivity {

    private TieneNull tieneNull;

    private RiskLevelClassifier frase = new RiskLevelClassifier();
    private Calculatehealth calcular = new Calculatehealth();

    private EditText textNroCig, textNroAnio;
    private TextView textView, textView2;
    private HalfGauge idMedidor;
    private com.ekn.gruzer.gaugelibrary.Range Range1, Range2, Range3, Range4;
    private int SetearGrafica;

    private PopupHelper popupHelper;
    private FraseHandler fraseHandler;
    private KeyboardManager keyboardManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textNroCig = findViewById(R.id.textNroCig);
        textNroAnio = findViewById(R.id.textNroAnio);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        popupHelper = new PopupHelper(this);
        fraseHandler = new FraseHandler(frase, calcular);
        keyboardManager = new KeyboardManager(this);

        //icono en el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setIcon(R.mipmap.ic_launcher); agrega el icono al lado de la letra. Para tenerlo
        //aca empiezo ahcer el medidor
        idMedidor = findViewById(R.id.idMedidor);

        tieneNull = new TieneNull(this);



        // Botón de ayuda (ImageButton) que muestra la ventana emergente
        ImageButton helpButton = findViewById(R.id.imageButton);
        helpButton.setOnClickListener(v -> popupHelper.showPopupWindow(v));


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
    public void verify(View view){
        String cig = textNroCig.getText().toString();
        String anio = textNroAnio.getText().toString();

        //notificacion de error
        tieneNull.tieneNull(cig, "Falta la cantidad de cigarrillos diarios");
        tieneNull.tieneNull(anio, "Falta la cantidad de años que fumas");

        this.validateDataAndCalculate(cig,anio);

    }

    private void validateDataAndCalculate(String cig, String anio) {

        if(cig.length() != 0 && anio.length() !=0){
            this.displayCalculationResult();
            this.generatephrase();
            idMedidor.setValue(calcular.calculatehealth(Integer.parseInt(cig),Integer.parseInt(anio)));
            this.cerrarTeclado();
        }
    }

    private void cerrarTeclado() {
        View view = this.getCurrentFocus();
        keyboardManager.closeKeyboard(view);
    }

    // hace el calculo dado
    public void displayCalculationResult(){
        int valor1 = Integer.parseInt(textNroCig.getText().toString());
        int valor2 = Integer.parseInt(textNroAnio.getText().toString());
        textView.setText(String.valueOf(calcular.calculatehealth(valor1,valor2)));
    }

    public void generatephrase() {
        int valor1 = Integer.parseInt(textNroCig.getText().toString());
        int valor2 = Integer.parseInt(textNroAnio.getText().toString());
        fraseHandler.generatephrase(valor1, valor2, textView2);
    }

}