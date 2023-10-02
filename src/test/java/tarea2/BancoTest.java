package tarea2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class BancoTest {
    private Banco banco;
    private ASFIAsesor asfiAsesor;

    @BeforeEach
    void setUp() {
        asfiAsesor = mock(ASFIAsesor.class);
        banco = new Banco(asfiAsesor);
    }

    @Test
    void testGetMaximoPrestamoCategoriaA() {
        when(asfiAsesor.consultarCategoria("CI123")).thenReturn("A");

        int maxPrestamo = banco.getMaximoPrestamo("CI123");
        assertEquals(200000, maxPrestamo);
    }

    @Test
    void testGetMaximoPrestamoCategoriaB() {
        when(asfiAsesor.consultarCategoria("CI456")).thenReturn("B");

        int maxPrestamo = banco.getMaximoPrestamo("CI456");
        assertEquals(100000, maxPrestamo);
    }

    @Test
    void testGetMaximoPrestamoCategoriaC() {
        when(asfiAsesor.consultarCategoria("CI789")).thenReturn("C");

        int maxPrestamo = banco.getMaximoPrestamo("CI789");
        assertEquals(0, maxPrestamo);
    }

}
