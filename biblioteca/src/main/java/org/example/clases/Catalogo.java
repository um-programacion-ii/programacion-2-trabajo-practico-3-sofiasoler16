package org.example.clases;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Libro> libros;

    public Catalogo() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        this.libros.add(libro);
    }

    public Libro buscarPorISBN(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public List<Libro> obtenerLibrosDisponibles() {
        List<Libro> disponibles = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getEstado() == enums.EstadoLibro.DISPONIBLE) {
                disponibles.add(libro);
            }
        }
        return disponibles;
    }

}
