package tarea1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class NumbersReverserTest {

    private NumbersReverser numbersReverser;

    @BeforeEach
    void setUp() {
        numbersReverser = new NumbersReverser();
    }

    @ParameterizedTest(name = "Reverse of {0} is {1}")
    @CsvSource({"0, 0", "100, 001","12345, 54321", "987654321, 123456789"})
    @DisplayName("Test reverse for valid positive numbers")
    void testReverseValidPositiveNumbers(int input, String expected) throws Exception {
        String result = numbersReverser.invertir(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "Reverse of {0} is {1}")
    @CsvSource({"-1", "-100", "-12345"})
    @DisplayName("Test reverse for invalid negative numbers")
    void testReverseInvalidNegativeNumbers(int input) {
        assertThrows(IllegalArgumentException.class, () -> numbersReverser.invertir(input));
    }

    @ParameterizedTest(name = "Reverse of {0} is {1}")
    @CsvSource({"1, 1", "9, 9"})
    @DisplayName("Test reverse for single-digit positive numbers")
    void testReverseSingleDigitPositiveNumbers(int input, String expected) throws Exception {
        String result = numbersReverser.invertir(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "Reverse of {0} is {1}")
    @CsvSource({"0, 0", "000, 0", "00000, 0"})
    @DisplayName("Test reverse for zero")
    void testReverseZero(int input, String expected) throws Exception {
        String result = numbersReverser.invertir(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "Reverse of {0} is {1}")
    @CsvSource({"1, 1", "10, 01", "001, 1"})
    @DisplayName("Test reverse for numbers with leading zeros")
    void testReverseLeadingZeros(int input, String expected) throws Exception {
        String result = numbersReverser.invertir(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "Reverse of {0} is {1}")
    @CsvSource({"1234567890, 0987654321", "1000000000, 0000000001"})
    @DisplayName("Test reverse for large numbers")
    void testReverseLargeNumbers(int input, String expected) throws Exception {
        String result = numbersReverser.invertir(input);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test reverse for negative zero")
    void testReverseNegativeZero() throws Exception {
        int input = -0;
        String expected = "0";
        String result = numbersReverser.invertir(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "Reverse of {0} is {1}")
    @CsvSource({"-1, 1", "-10, 01", "-001, 1", "-00010, 01"})
    @DisplayName("Test reverse for negative numbers with leading zeros")
    void testReverseLeadingZerosInNegativeNumbers(int input) {
        assertThrows(IllegalArgumentException.class, () -> numbersReverser.invertir(input));
    }


    @Test
    @DisplayName("Test reverse for the string '0'")
    void testReverseZeroAsString() throws Exception {
        int input = Integer.parseInt("0");
        String expected = "0";
        String result = numbersReverser.invertir(input);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test reverse for a non-numeric character")
    void testReverseNonNumericCharacter() {
        assertThrows(NumberFormatException.class, () -> numbersReverser.invertir(Integer.parseInt("A")));
    }

    @Test
    @DisplayName("Performance test for reversing a large number")
    void testPerformance() throws Exception {
        int input = 1234567890;
        String expected = "0987654321";
        long startTime = System.currentTimeMillis();
        String result = numbersReverser.invertir(input);
        long endTime = System.currentTimeMillis();
        assertEquals(expected, result);
        long executionTime = endTime - startTime;
        assertTrue(executionTime < 100, "Performance test took too long: " + executionTime + "ms");
    }


}