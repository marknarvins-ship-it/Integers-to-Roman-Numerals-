import java.util.Scanner;

public class RomanNumerals {
	private static final int[] VALUES = {
			1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
	};
	
	private static final String[] ROMANS = {
			"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
	};
	
	public static String toRomanWithExplanation(int num) {
		if (num < 1 || num > 3999) {
			return "Invalid input. Enter a number between 1 and 3999.";
		}
		
		StringBuilder romanResult = new StringBuilder();
		StringBuilder mathExplanation = new StringBuilder();
		int original = num;

		for (int i = 0; i < VALUES.length; i++) {
			while (num >= VALUES[i]) {
				num -= VALUES[i];
				romanResult.append(ROMANS[i]);

				if (mathExplanation.length() > 0) {
					mathExplanation.append(" + ");
				}

				// For subtractive notation, explain it as a subtraction
				if (ROMANS[i].length() == 2) {
					char first = ROMANS[i].charAt(1);
					char second = ROMANS[i].charAt(0);
					int val1 = romanCharToValue(first);
					int val2 = romanCharToValue(second);
					mathExplanation.append(val1).append(" - ").append(val2);
				} else {
					mathExplanation.append(VALUES[i]);
				}
			}
		}

		return "Roman Numeral: " + romanResult + "\nExplanation: " + romanResult + " = " + mathExplanation.toString() + " = " + original;
	}

	private static int romanCharToValue(char ch) {
		switch (ch) {
			case 'I': return 1;
			case 'V': return 5;
			case 'X': return 10;
			case 'L': return 50;
			case 'C': return 100;
			case 'D': return 500;
			case 'M': return 1000;
			default: return 0;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String choice;

		do {
			System.out.print("Enter an integer between 1 to 3999: ");
			int number = scanner.nextInt();

			System.out.println(toRomanWithExplanation(number));

			System.out.print("Would you like to convert another number? (y/n): ");
			choice = scanner.next().trim().toLowerCase();
		} while (choice.equals("y"));

		System.out.println("Thank you and Good Night!");
		scanner.close();
	}

}
