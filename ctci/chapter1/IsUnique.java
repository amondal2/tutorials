import java.util.*;

public class IsUnique {
    public static boolean isUnique(String s) {
        Set<Character> charSet = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (charSet.contains(s.charAt(i))) {
                return false;
            } else {
                charSet.add(s.charAt(i));
            }
        }
        return true;

    }

    public static void main(String[] args) {
        assert isUnique("abcde") == true;
        assert isUnique("aaabbb") == false;
        assert isUnique("z") == true;
        assert isUnique("hhhppp") == false;
    }
}