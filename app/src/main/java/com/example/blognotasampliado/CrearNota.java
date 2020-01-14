package com.example.blognotasampliado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

public class CrearNota extends AppCompatActivity {
    private Button btnCrear;
    private EditText editNombre;
    private EditText editComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_nota);
        btnCrear = (Button) findViewById(R.id.btnCrear);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editComentario = (EditText) findViewById(R.id.editComentario);
    }

    public void guardar(View v){
        //Insertamos un nuevo elemento en base de datos
        db.insertar(editNombre.getText().toString(),editComentario.getText().toString());
        //Actualizamos la lista de comentarios
        lista=db.getComments();
        //Actualizamos el adapter y lo asociamos de nuevo al spinner
        spinnerAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,lista);
        spinComentarios.setAdapter(spinnerAdapter);
        //Limpiamos el formulario
        editNombre.setText("");
        editComentario.setText("");
    }
}
