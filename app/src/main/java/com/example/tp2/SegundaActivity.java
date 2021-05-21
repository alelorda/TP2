package com.example.tp2;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity {

    private Button btnConvertir,btnReiniciar2;
    private EditText eTnIngresoDinero;
    private RadioButton rBttnDolar,rBtnEuro,rBtnBrasil;

    private TextView eTResultado;
    private Double monto, montoFinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        btnConvertir = findViewById(R.id.btnConvertir);
        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertir();
            }
        });
        btnReiniciar2 = findViewById(R.id.btnReiniciar2);
        btnReiniciar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        eTnIngresoDinero = findViewById(R.id.eTnIngresoDinero);
        rBttnDolar = findViewById(R.id.rBttnDolar);
        rBtnEuro = findViewById(R.id.rBtnEuro);
        rBtnBrasil = findViewById(R.id.rBtnBrasil);
        eTResultado = findViewById(R.id.eTResultado);
    }

    private void convertir(){
        String ingreso = eTnIngresoDinero.getText().toString().replace(',','.');
        String moneda = "";
        if(!ingreso.isEmpty()){
            monto = Double.parseDouble(ingreso);

            if(rBttnDolar.isChecked()){
                montoFinal = monto / 162;
                moneda = "U$S";
            }

            if(rBtnEuro.isChecked()){
                montoFinal = monto / 190;
                moneda = "€";
            }

            if(rBtnBrasil.isChecked()){
                montoFinal = monto / 100;
                moneda = "R$";
            }

            eTResultado.setText(String.format("%.2f"+moneda,montoFinal).replace('.',','));

        }
    }
}