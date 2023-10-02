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

        String maxPrestamo = banco.getMaximoPrestamo("CI123");
        assertEquals("maximo a prestar 200000", maxPrestamo);
    }

    @Test
    void testGetMaximoPrestamoCategoriaB() {
        when(asfiAsesor.consultarCategoria("CI456")).thenReturn("B");

        String maxPrestamo = banco.getMaximoPrestamo("CI456");
        assertEquals("maximo a prestar 100000", maxPrestamo);
    }

    @Test
    void testGetMaximoPrestamoCategoriaC() {
        when(asfiAsesor.consultarCategoria("CI789")).thenReturn("C");

        String maxPrestamo = banco.getMaximoPrestamo("CI789");
        assertEquals("no se puede prestar ningún monto ALERTA!", maxPrestamo);
    }

}
