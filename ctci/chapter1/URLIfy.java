public class URLIfy {
    public static String urlify(String s, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(urlify("Mr John Smith    ", 13));
        System.out.println(urlify("Agastya Mondal  ", 14));
    }
}