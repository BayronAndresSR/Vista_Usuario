package com.example.contigoperu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class RegistroCelularActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_celular);

        MaterialButton btnIngresarPhone = findViewById(R.id.btnIngresarPhone);
        btnIngresarPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirValidarCelularActivity();
            }
        });

    }

    void abrirValidarCelularActivity(){
        Intent i = new Intent(this,ValidacionCelularActivity.class);
        startActivity(i);
    }
}