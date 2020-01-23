package com.example.blognotasampliado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true; /** true -> el menú ya está visible */
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.crearNota) {
            crear();
            return true;
        }
        if (id == R.id.verNota) {
            ver();
            return true;
        }
        if (id == R.id.eliminarNota) {
            eliminar();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void crear(){
        Intent intent = new Intent (this, CrearNota.class);
        startActivity(intent);
    }

    public void ver(){
        Intent intent = new Intent (this, VerNota.class);
        startActivity(intent);
    }

    public void eliminar(){
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
