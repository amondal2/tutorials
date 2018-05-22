public class StringCompression {
    public static String compressString(String input) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i=0; i < input.length(); i++) {
            count++;
            if (i+1 >= input.length() || input.charAt(i) != input.charAt(i+1)) {
                sb.append(input.charAt(i));
                sb.append(count);
                count = 0;
            }
        }
        String compressed = sb.toString();
        return input.length() < compressed.length() ? input : compressed; 
    }

    public static void main(String[] args) {
        assert compressString("aabcccccaaa") == "a2b1c5a3";
        assert compressString("abcd") == "abcd";
    }
}