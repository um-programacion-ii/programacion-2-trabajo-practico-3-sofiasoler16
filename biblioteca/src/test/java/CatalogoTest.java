

import org.example.clases.Libro;
import org.example.clases.Catalogo;
import enums.EstadoLibro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CatalogoTest {
    private Catalogo catalogo;
    private Libro libro1;
    private Libro libro2;

    @BeforeEach
    void setUp() {
        catalogo = new Catalogo();
        libro1 = new Libro("978-3-16-148410-0", "Clean Code", "Robert C. Martin");
        libro2 = new Libro("978-0-13-235088-4", "Clean Architecture", "Robert C. Martin");
        catalogo.agregarLibro(libro1);
        catalogo.agregarLibro(libro2);
    }

    @Test
    void testBuscarPorIsbn() {
        Libro libro = catalogo.buscarPorISBN("978-3-16-148410-0");
        assertNotNull(libro);
        assertEquals("Clean Code", libro.getTitulo());
    }

    @Test
    void testObtenerLibrosDisponibles() {
        List<Libro> libros = catalogo.obtenerLibrosDisponibles();
        assertEquals(2, libros.size());
    }

    @Test
    void agregarLibro() {
        catalogo.agregarLibro(libro1);
        assertEquals(3, catalogo.obtenerLibrosDisponibles().size());
    }
}
