package org.example.clases;

import org.example.excepciones.LibroNoDisponibleException;
import org.example.excepciones.LibroNoEncontradoException;

import java.util.ArrayList;
import java.util.List;



public class SistemaPrestamos {
    private Catalogo catalogo;
    private List<Prestamo> prestamos;

    public SistemaPrestamos() {
        this.catalogo = new Catalogo();
        this.prestamos = new ArrayList<>();
    }

    public Prestamo prestarLibro(String isbn) {
        Libro libro = catalogo.buscarPorISBN(isbn);

        if (libro == null) {
            throw new LibroNoEncontradoException("El libro no existe en el catálogo con ese ISBN: " + isbn);
        }

        if (libro.getEstado() == enums.EstadoLibro.PRESTADO) {
            throw new LibroNoDisponibleException("El libro ya fue prestado.");
        }

        libro.setEstado(enums.EstadoLibro.PRESTADO);
        return new Prestamo(libro);
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
}
