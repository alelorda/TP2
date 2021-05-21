package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PrimeraActivity extends AppCompatActivity {

    private Button btnSumar, btnRestar, btnZoomMas,btnZoomMenos,btnOcultar,btnReset;
    private TextView txvContador;
    private int contador;
    private int ValorTexto  = 36;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__primera);
        contador = 0;
        btnSumar = findViewById(R.id.btnSumar);
        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumar();
            }
        });

        btnRestar = findViewById(R.id.btnRestar);
        btnRestar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                restar();
            }
        });

        btnZoomMas = findViewById(R.id.btnZoomMas);
        btnZoomMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zoomMas();
            }
        });

        btnZoomMenos = findViewById(R.id.btnZoomMenos);
        btnZoomMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zoomMenos();
            }
        });

        btnOcultar = findViewById(R.id.btnOcultar);
        btnOcultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultar();
            }
        });

        btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        txvContador =  findViewById(R.id.txvContador);
        txvContador.setText(Integer.toString(contador));
    }
    
    private void sumar(){
        contador ++;
        txvContador.setText(Integer.toString(contador));
    }

    private void restar(){
        contador --;
        txvContador.setText(Integer.toString(contador));
    }

    private void zoomMas(){
        if (ValorTexto < 100){
            ValorTexto = ValorTexto + 1;
            txvContador.setTextSize(ValorTexto);
        }
    }

    private void zoomMenos(){
        if (ValorTexto > 10){
            ValorTexto = ValorTexto - 1;
            txvContador.setTextSize(ValorTexto);
        }
    }

    private void ocultar(){
        txvContador.setVisibility(View.GONE);
    }

    private void reset(){
        contador = 0;
        txvContador.setText(Integer.toString(contador));
        txvContador.setVisibility(View.VISIBLE);
    }
}