package com.example.contigoperu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class TestPacienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_paciente);

        MaterialButton btnIrSolicitud = findViewById(R.id.btn_ir_a_solocitud_cita);
        btnIrSolicitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IrASolicitudCitaActivity();
            }
        });
    }

    void IrASolicitudCitaActivity(){
        Intent i = new Intent(this,SolicitudCitaActivity.class);
        startActivity(i);
    }

}