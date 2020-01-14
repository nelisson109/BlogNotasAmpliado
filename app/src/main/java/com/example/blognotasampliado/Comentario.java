package com.example.blognotasampliado;//Clase para representar un comentario

public class Comentario {

    //Campos correspondientes a la base de datos
    int id;
    String nombre;
    String comentario;

    //Constructor
    public Comentario(int _id, String _nombre, String _comentario){
        id=_id;
        nombre=_nombre;
        comentario=_comentario;
    }

    //Represetación del objeto como cadena de texto
    @Override
    public String toString() {
        return nombre;
    }

    //Métodos de acceso a cada atributo de la clase
    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getComentario(){
        return comentario;
    }

}
