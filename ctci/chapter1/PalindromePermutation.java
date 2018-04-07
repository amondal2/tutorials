import java.util.HashMap;
import java.util.Arrays;

public class PalindromePermutation {
    // Steps to check if a string is permutation of a palindrome
    // 1. create a frequency map of all of the characters in the string
    // 2. check that only at most one character has an odd count

    public static HashMap<Character,Integer> constructFrequencyCount(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            // ignore non-letter characters 
            Character c = Character.toLowerCase(s.charAt(i));
            if (Character.isLetter(c)) {
                Integer count = frequencyMap.get(c);
                if (count != null) {
                   frequencyMap.put(c, count+1); 
                } else {
                    frequencyMap.put(c, 1);
                }
            }
        }
        return frequencyMap;
    }

    public static boolean isPalidromePermutation(String s) {
        int oddCount = 0;
        HashMap<Character, Integer> frequencies = constructFrequencyCount(s);
        for (Character key : frequencies.keySet()) { 
            Integer count = frequencies.get(key);
            if (count % 2 == 1) {
                oddCount++;
            }
            if (oddCount > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        assert isPalidromePermutation("tacocat") == true;
        assert isPalidromePermutation("tactcoapapa") == true;
        assert isPalidromePermutation("agastya") == false;  
    }
}