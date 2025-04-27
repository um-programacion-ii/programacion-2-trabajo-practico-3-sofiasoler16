package org.example.clases;

import org.example.excepciones.LibroNoDisponibleException;
import org.example.excepciones.UsuarioNoEncontradoException;

import java.util.HashMap;
import java.util.Map;

public class GestionUsuarios {
    private Map<String, Usuario> usuariosRegistrados;
    private Catalogo catalogo;
    private SistemaPrestamos sistemaPrestamos;


    public GestionUsuarios(Catalogo catalogo, SistemaPrestamos sistemaPrestamos) {
        this.usuariosRegistrados = new HashMap<>();
        this.catalogo = catalogo;
        this.sistemaPrestamos = sistemaPrestamos;
    }

    public void registrarUsuario(String nombre) {
        if (!usuariosRegistrados.containsKey(nombre)) {
            usuariosRegistrados.put(nombre, new Usuario(nombre));
        }
    }

    public Usuario buscarUsuario(String nombre) {
        return usuariosRegistrados.get(nombre);
    }

    public Map<String, Usuario> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    public void registrarPrestamo(String nombreUsuario, String isbn) {
        Usuario usuario = usuariosRegistrados.get(nombreUsuario);

        if (usuario == null) {
            throw new UsuarioNoEncontradoException("No se encontró el usuario: " + nombreUsuario);
        }

        Libro libro = catalogo.buscarPorISBN(isbn);
        if (libro == null || libro.getEstado() == enums.EstadoLibro.PRESTADO) {
            throw new LibroNoDisponibleException("El libro no está disponible.");
        }

        Prestamo prestamo = sistemaPrestamos.prestarLibro(isbn);
        usuario.agregarPrestamo(prestamo);
    }


}