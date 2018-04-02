import java.util.Arrays;

public class IsPermutation {
    public static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static boolean isPermutation(String a, String b) {
        return sort(a).equals(sort(b));
    }

    public static void main(String[] args) {
        assert isPermutation("aba", "baa") == true;
        assert isPermutation("abc", "ccc") == false;
        assert isPermutation("gus", "sug") == true;

    }
}