package org.example.clases;

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
        if (libro != null) {
            Prestamo prestamo = new Prestamo(libro);
            prestamos.add(prestamo);
            libro.setEstado(enums.EstadoLibro.PRESTADO);
            return prestamo;
        }
        return null;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
}
