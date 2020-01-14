package com.example.blognotasampliado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class VerNota extends AppCompatActivity {

    private Spinner spinComentarios;
    private Button btnVer;
    private EditText txtNombre;
    private EditText txtComentario;
    private Comentario c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_nota);
        spinComentarios = (Spinner) findViewById(R.id.spinComentarios);
        btnVer = (Button) findViewById(R.id.btnVer);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtComentario = (EditText) findViewById(R.id.txtComentario);


        txtNombre.setEnabled(false);
        txtComentario.setEnabled(false);
    }

    public void ver(View v){
        if(c!=null) {
            txtNombre.setText(c.getNombre());
            txtComentario.setText(c.getComentario());
        }
    }
}
