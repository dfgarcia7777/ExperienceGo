package com.dfgarcia.experiencego.Model;

public class Eventos {
    private int imagen;
    private String textoImagen;

    public Eventos(int imagen, String textoImagen) {
        this.imagen = imagen;
        this.textoImagen = textoImagen;
    }

    public Eventos() {
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTextoImagen() {
        return textoImagen;
    }

    public void setTextoImagen(String textoImagen) {
        this.textoImagen = textoImagen;
    }

    @Override
    public String toString() {
        return "Eventos{" +
                "imagen=" + imagen +
                ", textoImagen='" + textoImagen + '\'' +
                '}';
    }
}
