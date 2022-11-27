package com.dfgarcia.experiencego.Model;

public class Eventos {
    private int imagen;

    public Eventos(int imagen) {
        this.imagen = imagen;
    }

    public Eventos() {
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Eventos{" +
                "imagen=" + imagen +
                '}';
    }
}
