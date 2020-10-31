package com.example.contigoperu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class DatosPersonalesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_personales);

        MaterialButton btnIniciarTest = findViewById(R.id.btnIniciarTest);
        btnIniciarTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirTestPacienteActivity();
            }
        });
    }

    void abrirTestPacienteActivity(){
        Intent i = new Intent(this,TestPacienteActivity.class);
        startActivity(i);
    }
}