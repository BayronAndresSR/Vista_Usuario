package com.example.contigoperu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class ValidacionCelularActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validacion_celular);


        MaterialButton btnIngresarCodigo = findViewById(R.id.btnIngresarCodigo);
        btnIngresarCodigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirOtraActividad();
            }
        });
    }

    void abrirOtraActividad(){
        Intent intento = new Intent(this , DatosPersonalesActivity.class);
        startActivity(intento);
    }
}