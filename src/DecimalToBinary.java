
import java.util.Random;

public class DecimalToBinary {

	public static void main(String[] args) {
		if (!DecimalToBinary.runUnitTests()) {
			System.out.println("Failure");
			return;
		}
		System.out.println("Success");
	}

	public static String decimal2binary(int decimal) {
		String result = "";
		while (decimal != 0) {
			result += String.valueOf(decimal % 2);
			decimal /= 2;
		}
		return new StringBuffer(result).reverse().toString();
	}

	public static boolean runUnitTests() {
		Random randomGenerator = new Random();
		for (int i = 0; i < 100; i++) {
			int decimal = randomGenerator.nextInt(100);
			String tested = DecimalToBinary.decimal2binary(decimal);
			String expected = Integer.toBinaryString(decimal);
			if (!tested.equals(expected)) {
				System.err.println(Integer.toString(decimal)+": expected '"+expected+"' got '"+tested+"'");
				return false;
			}
		}
		return true;
	}
}
