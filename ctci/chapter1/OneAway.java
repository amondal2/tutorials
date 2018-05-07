public class OneAway { 
    public static boolean isOneAway(String s1, String s2) { 
        if (s1.equals(s2)) { 
            return true;
        }

        int lengthDifference = Math.abs(s1.length() - s2.length());

        if (lengthDifference > 1) {
            return false;
        } else if (lengthDifference == 0) {
            return isReplace(s1, s2);
        } else {
            return isInsertOrDelete(s1, s2) || isInsertOrDelete(s2, s1);
        }

    }

    public static boolean isReplace(String s1, String s2) {
        // function that checks if one string is one character replacement of another
        // this means that the strings are different at at most one position
        int totalDiff = 0;
        for (int i=0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                totalDiff++;
            }
        }

        if (totalDiff > 1) {
            return false;
        }

        return true;
    }

    public static boolean isInsertOrDelete(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        assert isOneAway("pale", "ple") == true;
        assert isOneAway("pales", "pale") == true;
        assert isOneAway("pale", "bale") == true;
        assert isOneAway("pale", "bake") == false;
    }
}