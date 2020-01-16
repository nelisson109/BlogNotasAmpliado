package com.example.blognotasampliado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.app.AlertDialog;

import java.util.ArrayList;

public class CrearNota extends MainActivity {
    private Button btnCrear;
    private EditText editNombre;
    private EditText editComentario;
    private MyOpenHelper db;
    private ArrayList<Comentario> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_nota);
        btnCrear = (Button) findViewById(R.id.btnCrear);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editComentario = (EditText) findViewById(R.id.editComentario);
        db = getDb();
    }

    public void guardar(View v){
        //Insertamos un nuevo elemento en base de datos
        db.insertar(editNombre.getText().toString(),editComentario.getText().toString());
        //Actualizamos la lista de comentarios

        //Limpiamos el formulario
        editNombre.setText("");
        editComentario.setText("");

        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Creación de Nota");
        alerta.setMessage("La nota ha sido creada correctamente");
        alerta.setPositiveButton("ACEPTAR",null);
        alerta.create();
        alerta.show();
    }
}
