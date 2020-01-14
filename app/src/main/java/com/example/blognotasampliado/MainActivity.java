package com.example.blognotasampliado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinComentarios;
    private MyOpenHelper db;
    private ArrayAdapter spinnerAdapter;
    private ArrayList<Comentario> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = db.getComments();

    }

    public void crear(View v){
        Intent intent = new Intent (v.getContext(), CrearNota.class);
        startActivity(intent);
    }

    public void ver(View v){
        Intent intent = new Intent (v.getContext(), VerNota.class);
        startActivity(intent);
    }

    public void eliminar(View v){
        Intent intent = new Intent (v.getContext(), EliminarNota.class);
        startActivity(intent);
    }

    public ArrayList<Comentario> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Comentario> lista) {
        this.lista = lista;
    }
}
