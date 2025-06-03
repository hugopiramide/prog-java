package com.liceolapaz.des.hcd;

public class Libro {
    private int isbn;
    private String titulo;
    private String genero;
    private int paginas;
    private boolean disponibilidad;
    public Libro(int isbn, String titulo, String genero, int paginas) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
        this.disponibilidad = true; //Una vez añadamos el libro, estará disponible
    }

    public int getISBN() {
        return isbn;
    }

    public String getTitulo() {
        if(titulo != null){
            return titulo;
        }
        return null;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public String toString(){
        return titulo;
    }
}