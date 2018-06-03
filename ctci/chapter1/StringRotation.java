public class StringRotation { 
    public static boolean isRotation(String s1, String s2) {
        // if s2 is a rotation of s1, then s2 will be 
        // a substring of s1 + s1
        // eg. s1: erbottlewat, s2: waterbottle
        // s1+s1: erbottlewaterbottlewat, of which s2 is a substring
        if (s1.length() == 0 || s2.length() == 0) {
            return false;
        }
        String concat = s1 + s1;
        return concat.contains(s2);
    }

    public static void main(String[] args) {
        assert StringRotation.isRotation("waterbottle", "erbottlewat") == true;
    }
}