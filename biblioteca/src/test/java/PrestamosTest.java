import org.example.clases.Catalogo;
import org.example.clases.Libro;
import org.example.clases.Prestamo;
import org.example.clases.SistemaPrestamos;
import enums.EstadoLibro;

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
}
