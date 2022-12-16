package com.dfgarcia.experiencego.Model;

import android.widget.DatePicker;

public class MisRecuerdos {
    private String titulo;
    private String fecha;
    private int imagen;

    public MisRecuerdos(String titulo, String fecha, int imagen) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.imagen = imagen;
    }

    public MisRecuerdos() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "MisRecuerdos{" +
                "titulo='" + titulo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", imagen=" + imagen +
                '}';
    }
}
