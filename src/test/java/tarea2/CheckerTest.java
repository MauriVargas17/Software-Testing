package tarea2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CheckerTest {

    private Checker checker;

    @BeforeEach
    void setup(){
        checker = new Checker();
    }
    @Test
    void testIsPalindromeWithPalindromeWord() {
        String word = "oro";
        boolean result = checker.isPalindrome(word);
        assert(result);
    }

    @Test
    void testIsPalindromeWithNonPalindromeWord() {
        String word = "jose";
        boolean result = checker.isPalindrome(word);
        assert(!result);
    }

    @ParameterizedTest
    @CsvSource({ "ana, true", "reconocer, true", "casa, false", "amor a roma, true" })
    void testIsPalindromeWithParameterizedCases(String word, boolean expectedResult) {
        boolean result = checker.isPalindrome(word);
        assert(result == expectedResult);
    }


}
