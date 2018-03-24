import java.util.HashMap;

public class RomanToInt {

    public static int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<Character,Integer>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int total = 0;
        int i = 0;
        while (i < s.length()) {
            if (i == s.length()-1) {
                total += romanMap.get(s.charAt(i));
                return total;
            } else if (romanMap.get(s.charAt(i+1)) > romanMap.get(s.charAt(i))) {
                total += (romanMap.get(s.charAt(i+1)) - romanMap.get(s.charAt(i)));
                i++;
            } else {
                total += romanMap.get(s.charAt(i));
            }
            i++;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCVI"));
        System.out.println(romanToInt("XVII"));
        System.out.println(romanToInt("DLCXVI"));
    }
}