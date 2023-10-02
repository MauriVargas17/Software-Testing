package tarea_en_clase_1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LotteryTest {

    @Mock
    private Service service;

    private Lottery lottery;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        lottery = new Lottery();
        lottery.service = service;
    }

    @Test
    @DisplayName("Test getPremio for age <= 10 with prime number")
    void testGetPremioAgeUnderOrEqualTo10WithPrime() {
        when(service.isPrime(2)).thenReturn(true);

        int result = lottery.getPremio(2);
        int expected = 200;

        assertEquals(expected, result);
        verify(service).isPrime(2);
    }

    @Test
    @DisplayName("Test getPremio for age <= 10 with non-prime number")
    void testGetPremioAgeUnderOrEqualTo10WithoutPrime() {
        when(service.isPrime(9)).thenReturn(false);

        int result = lottery.getPremio(9);
        int expected = 9;

        assertEquals(expected, result);
        verify(service).isPrime(9);
    }

    @Test
    @DisplayName("Test getPremio for age > 10 with prime number")
    void testGetPremioAgeGreaterThan10WithPrime() {
        when(service.isPrime(13)).thenReturn(true);

        int result = lottery.getPremio(13);
        int expected = 1040;

        assertEquals(expected, result);
        verify(service).isPrime(13);
    }

    @Test
    @DisplayName("Test getPremio for age > 10 with non-prime number")
    void testGetPremioAgeGreaterThan10WithoutPrime() {
        when(service.isPrime(15)).thenReturn(false);

        int result = lottery.getPremio(15);
        int expected = 0;

        assertEquals(expected, result);
        verify(service).isPrime(15);
    }

    @Test
    @DisplayName("Test getPremio with negative age")
    void testGetPremioWithNegativeAge() {
        assertThrows(IllegalArgumentException.class, () -> lottery.getPremio(-1));
        verify(service, never()).isPrime(anyInt());
    }
}
