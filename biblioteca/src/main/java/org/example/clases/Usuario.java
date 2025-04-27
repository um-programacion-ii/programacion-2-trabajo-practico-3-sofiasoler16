package org.example.clases;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private List<Prestamo> historialPrestamos;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.historialPrestamos = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }

    public List<Prestamo> getHistorialPrestamos() {
        return historialPrestamos;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        historialPrestamos.add(prestamo);
    }
}
