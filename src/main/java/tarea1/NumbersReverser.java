package tarea1;

public class NumbersReverser {

    public String invertir(int number) throws Exception{
        if (!(number >= 0)) {
            throw new IllegalArgumentException("Natural number required");
        }
        return recursive_reverser(String.valueOf(number), "");
    }

    private String recursive_reverser(String a, String b){
        if (a.isEmpty()) {
            return b;
        }
        return recursive_reverser(a.substring(1), a.charAt(0)+b);
    }
}