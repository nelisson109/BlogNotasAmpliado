package com.example.blognotasampliado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class EliminarNota extends AppCompatActivity {

    private Spinner spinComentarios;
    private Button btnVer;
    private Button btnEliminar;
    private EditText txtNombre;
    private EditText txtComentario;
    private Comentario c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_nota);
        spinComentarios = (Spinner) findViewById(R.id.spinComentarios);
        btnVer = (Button) findViewById(R.id.btnVer);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtComentario = (EditText) findViewById(R.id.txtComentario);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);


        txtNombre.setEnabled(false);
        txtComentario.setEnabled(false);
    }

    public void ver(View v){
        if(c!=null) {
            txtNombre.setText(c.getNombre());
            txtComentario.setText(c.getComentario());
        }
    }

    public void eliminar(View v){
        //Si hay algun comentario seleccionado lo borramos de la base de datos y actualizamos el spinner
        if(c!=null) {
            db.borrar(c.getId());
            lista = db.getComments();
            spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lista);
            spinComentarios.setAdapter(spinnerAdapter);
            //Limpiamos los datos del panel inferior
            txtNombre.setText("");
            txtComentario.setText("");
            //Eliminamos el Comentario actual puesto que ya no existe en base de datos
            c=null;
        }
    }
}
