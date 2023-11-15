package assignment;

import java.util.Random;

public class CatchyPhoneNumberGenerator {

	public static void main(String[] args) {
		String catchyPhoneNumber = generateCatchyPhoneNumber();
		System.out.println("Catchy Phone Number: " + catchyPhoneNumber);
	}

	public static String generateCatchyPhoneNumber() {
		Random random = new Random();
		StringBuilder phoneNumber = new StringBuilder();

		// Generate a random phone number
		for (int i = 0; i < 10; i++) {
			int digit = random.nextInt(10);
			phoneNumber.append(digit);
		}

		// Apply patterns
		applyRepetitivePattern(phoneNumber);
		applySequentialPattern(phoneNumber);
		applySymmetricalPattern(phoneNumber);
		applyConsecutiveDigitsPattern(phoneNumber);
		applySequentialNumbersPattern(phoneNumber);
		applyPalindromePattern(phoneNumber);
		applyPrimePattern(phoneNumber);
		applyFibonacciPattern(phoneNumber);

		return phoneNumber.toString();
	}

	public static void applyRepetitivePattern(StringBuilder phoneNumber) {
		Random random = new Random();
		if (random.nextBoolean()) {
			int digit = random.nextInt(10);
			for (int i = 0; i < phoneNumber.length(); i++) {
				phoneNumber.setCharAt(i, (char) (digit + '0'));
			}
		}
	}

	public static void applySequentialPattern(StringBuilder phoneNumber) {
		Random random = new Random();
		if (random.nextBoolean()) {
			String sequence = "1234567890";
			int start = random.nextInt(10);
			String subset = sequence.substring(start) + sequence.substring(0, start);
			for (int i = 0; i < phoneNumber.length(); i++) {
				phoneNumber.setCharAt(i, subset.charAt(i));
			}
		}
	}

	public static void applySymmetricalPattern(StringBuilder phoneNumber) {
		Random random = new Random();
		if (random.nextBoolean()) {
			for (int i = 0; i < 5; i++) {
				phoneNumber.setCharAt(i + 5, phoneNumber.charAt(i));
			}
		}
	}

	public static void applyConsecutiveDigitsPattern(StringBuilder phoneNumber) {
		Random random = new Random();
		if (random.nextBoolean()) {
			int start = random.nextInt(8); // To ensure a sequence of 3 digits can fit within 10 digits
			for (int i = start; i < start + 3; i++) {
				phoneNumber.setCharAt(i, (char) ((phoneNumber.charAt(i) + 1) % 10 + '0'));
			}
		}
	}

	public static void applySequentialNumbersPattern(StringBuilder phoneNumber) {
		Random random = new Random();
		if (random.nextBoolean()) {
			String sequence = "1234567890";
			int start = random.nextInt(8);
			String subset = sequence.substring(start, start + 8);
			for (int i = 0; i < 8; i++) {
				phoneNumber.setCharAt(i, subset.charAt(i));
			}
		}
	}

	public static void applyPalindromePattern(StringBuilder phoneNumber) {
		Random random = new Random();
		if (random.nextBoolean()) {
			int mid = phoneNumber.length() / 2;
			for (int i = 0; i < mid; i++) {
				phoneNumber.setCharAt(phoneNumber.length() - i - 1, phoneNumber.charAt(i));
			}
		}
	}

	public static void applyPrimePattern(StringBuilder phoneNumber) {
		Random random = new Random();
		if (random.nextBoolean()) {
			int num = Integer.parseInt(phoneNumber.toString());
			if (isPrime(num)) {
				phoneNumber.setCharAt(0, '2');
			}
		}
	}

	public static void applyFibonacciPattern(StringBuilder phoneNumber) {
		Random random = new Random();
		if (random.nextBoolean()) {
			int num = Integer.parseInt(phoneNumber.toString());
			if (isFibonacci(num)) {
				phoneNumber.setCharAt(0, '1');
			}
		}
	}

	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n == 2 || n == 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		int sqrtN = (int) Math.sqrt(n) + 1;
		for (int i = 5; i <= sqrtN; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		}
		return true;
	}

	public static boolean isFibonacci(int n) {
		int a = 0, b = 1;
		while (b < n) {
			int temp = b;
			b = a + b;
			a = temp;
		}
		return b == n;
	}
}