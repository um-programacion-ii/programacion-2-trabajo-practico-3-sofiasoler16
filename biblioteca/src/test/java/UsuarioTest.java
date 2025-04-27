import org.example.clases.*;
import enums.EstadoLibro;

import org.example.excepciones.LibroNoDisponibleException;
import org.example.excepciones.UsuarioNoEncontradoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UsuarioTest {

    @Mock
    private Catalogo catalogo;

    @Mock
    private SistemaPrestamos sistemaPrestamos;

    @InjectMocks
    private GestionUsuarios gestionUsuarios;

    @Test
    void testRegistrarPrestamo() {
        gestionUsuarios.registrarUsuario("usuario1");

        Usuario usuario = gestionUsuarios.buscarUsuario("usuario1");
        Libro libro = new Libro("978-3-16-148410-0", "Clean Code", "Robert C. Martin");

        when(catalogo.buscarPorISBN("978-3-16-148410-0")).thenReturn(libro);
        when(sistemaPrestamos.prestarLibro("978-3-16-148410-0"))
                .thenReturn(new Prestamo(libro));

        gestionUsuarios.registrarPrestamo("usuario1", "978-3-16-148410-0");

        verify(sistemaPrestamos).prestarLibro("978-3-16-148410-0");
        assertEquals(1, usuario.getHistorialPrestamos().size());
    }

    @Test
    void testRegistrarPrestamoUsuarioNoExistente() {
        assertThrows(UsuarioNoEncontradoException.class, () -> {
            gestionUsuarios.registrarPrestamo("usuarioInexistente", "978-3-16-148410-0");
        });
    }


}
