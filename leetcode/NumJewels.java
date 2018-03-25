import java.util.HashMap;

public class NumJewels {
    public static int numJewels(String j, String s) {
        HashMap<Character, String> jewelMap = new HashMap<Character, String>();
        for (int i=0; i < j.length(); i++) {
            jewelMap.put(j.charAt(i), "True");
        }
        int count = 0;
        for (int k=0; k < s.length(); k++) {
            if (jewelMap.get(s.charAt(k)) != null) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        assert numJewels("aA", "aAAbbbb") == 3;
        assert numJewels("z", "ZZ") == 0;
    }
}