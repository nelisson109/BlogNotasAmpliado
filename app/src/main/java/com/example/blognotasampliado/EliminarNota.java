package com.example.blognotasampliado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.app.AlertDialog;

import java.util.ArrayList;

public class EliminarNota extends MainActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinComentarios;
    private ArrayAdapter spinnerAdapter;
    private MyOpenHelper db;
    private ArrayList<Comentario> lista;
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

        db = getDb();
        lista = db.getComments();
        spinnerAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,lista);
        spinComentarios.setAdapter(spinnerAdapter);
        spinComentarios.setOnItemSelectedListener(this);


        txtNombre.setEnabled(false);
        txtComentario.setEnabled(false);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminar();
            }
        });

    }

    public void ver(View v){
        if(c!=null) {
            txtNombre.setText(c.getNombre());
            txtComentario.setText(c.getComentario());
        }
    }

    public void aceptar(){
        db.borrar(c.getId());
        lista = db.getComments();
        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lista);
        spinComentarios.setAdapter(spinnerAdapter);
        txtNombre.setText("");
        txtComentario.setText("");
        c=null;
    }

    public void eliminar (){
        //Si hay algun comentario seleccionado lo borramos de la base de datos y actualizamos el spinner
     /*   if(c!=null) {
            db.borrar(c.getId());
            lista = db.getComments();
            spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lista);
            spinComentarios.setAdapter(spinnerAdapter);
            //Limpiamos los datos del panel inferior
            txtNombre.setText("");
            txtComentario.setText("");
            //Eliminamos el Comentario actual puesto que ya no existe en base de datos
            c=null;
        }*/
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("CONFIRMACIÓN del borrado");
        alerta.setMessage("¿Quieres borrar la NOTA?");
        alerta.setCancelable(false);
        alerta.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo, int id) {
                aceptar();
            }
        });
        alerta.setNegativeButton("NO",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo, int id) {
                finish();
            }
        });
        alerta.setNegativeButton("NO",null);
        alerta.create();
        alerta.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.spinComentarios) {
            //Si hay elementos en la base de datos, establecemos el comentario actual a partir del
            //indice del elemento seleccionado en el spinner
            if(lista.size()>0) {
                c = lista.get(position);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
