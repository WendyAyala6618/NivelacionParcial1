package com.wendy.ejercicionivelacion;

public class Jugadores {

    private  String Nombre;
    private  int Puntos;

    public Jugadores(String nombre, int puntos) {
        Nombre = nombre;
        Puntos = puntos;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getPuntos() {
        return Puntos;
    }
}
