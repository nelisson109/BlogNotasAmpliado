package com.example.blognotasampliado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyOpenHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new MyOpenHelper(this);

    }

    public void crear(View v){
        Intent intent = new Intent (this, CrearNota.class);
        startActivity(intent);
    }

    public void ver(View v){
        Intent intent = new Intent (this, VerNota.class);
        startActivity(intent);
    }

    public void eliminar(View v){
        Intent intent = new Intent (this, EliminarNota.class);
        startActivity(intent);
    }

    public MyOpenHelper getDb() {
        return db;
    }

    public void setDb(MyOpenHelper db) {
        this.db = db;
    }

}
