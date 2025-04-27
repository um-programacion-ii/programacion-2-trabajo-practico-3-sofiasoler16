import org.example.clases.Catalogo;
import org.example.clases.Libro;
import org.example.clases.Prestamo;
import org.example.clases.SistemaPrestamos;
import enums.EstadoLibro;

import org.example.excepciones.LibroNoDisponibleException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PrestamosTest {
    @Mock
    private Catalogo catalogo;

    @InjectMocks
    private SistemaPrestamos sistemaPrestamos;

    @Test
    void testPrestarLibro() {
        Libro libro = new Libro("978-3-16-148410-0", "Clean Code", "Robert C. Martin");
        when(catalogo.buscarPorISBN("978-3-16-148410-0")).thenReturn(libro);

        Prestamo prestamo = sistemaPrestamos.prestarLibro("978-3-16-148410-0");

        assertNotNull(prestamo);
        verify(catalogo).buscarPorISBN("978-3-16-148410-0");
        assertEquals(EstadoLibro.PRESTADO, libro.getEstado());
    }

    @Test
    void testPrestarLibroInexistenteLanzaLibroNoDisponibleException() {
        when(catalogo.buscarPorISBN("9999")).thenReturn(null);

        Exception exception = assertThrows(LibroNoDisponibleException.class, () -> {
            sistemaPrestamos.prestarLibro("9999");
        });

        assertEquals("El libro no existe en el catálogo.", exception.getMessage());
    }

    @Test
    void testPrestarLibroYaPrestadoLanzaLibroNoDisponibleException() {
        Libro libroPrestado = new Libro("1234", "Effective Java", "Joshua Bloch");
        libroPrestado.setEstado(EstadoLibro.PRESTADO);
        when(catalogo.buscarPorISBN("1234")).thenReturn(libroPrestado);

        Exception exception = assertThrows(LibroNoDisponibleException.class, () -> {
            sistemaPrestamos.prestarLibro("1234");
        });

        assertEquals("El libro ya fue prestado.", exception.getMessage());
    }

}
