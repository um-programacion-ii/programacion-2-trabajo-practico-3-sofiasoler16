package org.example.clases;

import enums.EstadoLibro;

public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private enums.EstadoLibro estadoLibro;

    public Libro(String ISBN, String titulo, String autor) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.estadoLibro = EstadoLibro.DISPONIBLE;
    }

    public String getIsbn() {
        return ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public enums.EstadoLibro getEstado() {
        return estadoLibro;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEstado(enums.EstadoLibro estadoLibro) {
        this.estadoLibro = estadoLibro;
    }

}
