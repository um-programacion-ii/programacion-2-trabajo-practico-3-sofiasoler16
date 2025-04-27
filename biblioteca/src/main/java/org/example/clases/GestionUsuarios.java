package org.example.clases;

import java.util.HashMap;
import java.util.Map;

public class GestionUsuarios {

    private Map<String, Usuario> usuariosRegistrados;

    public GestionUsuarios() {
        this.usuariosRegistrados = new HashMap<>();
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
}