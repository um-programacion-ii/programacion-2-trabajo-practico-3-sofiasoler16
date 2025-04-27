package org.example.clases;

import java.time.LocalDate;

public class Prestamo {
    private LocalDate fechaPrestamo;
    private Libro libro;

    public Prestamo(Libro libro) {
        this.fechaPrestamo = LocalDate.now();
        this.libro = libro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }
    
}
