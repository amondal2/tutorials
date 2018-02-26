public class Reverse {
	public static int reverse(int num) {
		String numString = Integer.toString(num);
		int retVal = 0;
		if (num < 0) {
			String reversed = new StringBuilder(numString.substring(1, numString.length())).reverse().toString();
			retVal = Integer.parseInt(reversed) * -1;
		} else {
			String reversed = new StringBuilder(numString).reverse().toString();
			retVal = Integer.parseInt(reversed);
		}
		if (retVal > Math.pow(2, 31)) {
			return 0;
		}
		return retVal;
	}
	public static void main(String[] args) {
		System.out.println(reverse(123));
		System.out.println(reverse(-123));
	}
}
