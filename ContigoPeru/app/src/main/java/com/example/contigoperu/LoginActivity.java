package com.example.contigoperu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.contigoperu.models.ConexionFirebase;
import com.example.contigoperu.models.UsuarioModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText inputNumeroDocumento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inputNumeroDocumento = findViewById(R.id.edt_numero_documento);

        final MaterialButton btnIniciarSesion = findViewById(R.id.btn_iniciar_sesion);
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IniciarSesionPacientePorDni();
            }
        });
    }

    void abrirOtraActividad(){
        Intent intento = new Intent(this , RegistroCelularActivity.class);
        startActivity(intento);
    }


    void MetodoEjemploCRUD(){//este metodo es de ejemplo para crear un usuario , y obtener ese usuario creado
        final DocumentReference nuevoUsuario = ConexionFirebase.getTablaUsuario().document();//conexion tabla usuario
        UsuarioModel nuevoUsuarioModel = new UsuarioModel();
        nuevoUsuarioModel.setId(nuevoUsuario.getId());
        nuevoUsuarioModel.setCelular("987654321");
        nuevoUsuarioModel.setClave("123456");
        nuevoUsuarioModel.setDni("98765412");
        nuevoUsuarioModel.setNombreUsuario("bayron");

        nuevoUsuario.set(nuevoUsuarioModel).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    mensajeExitoso();
                }else{
                    mensajeFAllido();
                }
            }
        });
    }


    void mensajeExitoso(){
        Toast.makeText(this,"GUARDADO",Toast.LENGTH_SHORT);
    }

    void mensajeFAllido(){
        Toast.makeText(this,"ERROR AL GUARDAR",Toast.LENGTH_SHORT);
    }


    private void IniciarSesionPacientePorDni(){
        String strDni = inputNumeroDocumento.getText().toString();
        Log.d("DNI",strDni);
        ConexionFirebase.getTablaUsuario().whereEqualTo("dni",strDni).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    if(task.getResult().getDocuments() != null && task.getResult().getDocuments().get(0) != null ){
                        UsuarioModel usuarioLogueado = task.getResult().getDocuments().get(0).toObject(UsuarioModel.class);
                        Log.d("DNI_U",usuarioLogueado.getDni());
                        abrirOtraActividad();
                    }else{
                        mensajeFAllido();
                    }
                }else{
                    mensajeFAllido();
                }
            }
        });
    }

}