package clases;

import enums.EstadoLibro;

public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private EstadoLibro estadoLibro;

    public Libro(String ISBN, String titulo, String autor, EstadoLibro estadoLibro) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.estadoLibro = estadoLibro;
    }
}
