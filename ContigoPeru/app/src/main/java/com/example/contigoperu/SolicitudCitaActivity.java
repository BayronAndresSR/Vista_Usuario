package com.example.contigoperu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class SolicitudCitaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_cita);

        MaterialButton btnSolicitarCita = findViewById(R.id.btnSolicitarCita);
        btnSolicitarCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirDashboardActivity();
            }
        });
    }

    void abrirDashboardActivity(){
        Intent i = new Intent(this,DashboardActivity.class);
        startActivity(i);
    }
}