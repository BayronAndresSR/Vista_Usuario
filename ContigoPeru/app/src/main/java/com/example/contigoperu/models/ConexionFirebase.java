package com.example.contigoperu.models;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class ConexionFirebase {

    private static FirebaseFirestore db ;
    private static CollectionReference getTablaUsuario ;//tabla de usuario

    private ConexionFirebase() {}

    public static FirebaseFirestore getDb(){
        if(db == null){
            db = FirebaseFirestore.getInstance();
        }
        return db;
    }


    public static CollectionReference getTablaUsuario() {
        if(getTablaUsuario == null){
            getTablaUsuario = getDb().collection("usuarios");
        }
        return getTablaUsuario;
    }

}
