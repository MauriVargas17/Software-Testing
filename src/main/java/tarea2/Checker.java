package tarea2;

public class Checker {

    public boolean isPalindrome(String word) {
        word = word.replaceAll("\\s+", "").toLowerCase();
        return word.equals(new StringBuilder(word).reverse().toString());
    }


}
