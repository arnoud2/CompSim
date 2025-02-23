package domein;

public class CompareParts {

	public boolean equal(int num1, int num2) {
		validateUnsignedInput(num1, num2);
		return num1 == num2;
	}

	public boolean notEqual(int num1, int num2) {
		validateUnsignedInput(num1, num2);
		return num1 != num2;
	}

	public boolean lessOrEqual(int num1, int num2) {
		validateUnsignedInput(num1, num2);
		return num1 <= num2;
	}

	public boolean greaterThan(int num1, int num2) {
		validateUnsignedInput(num1, num2);
		return num1 > num2;
	}

	public boolean greaterOrEqual(int num1, int num2) {
		validateUnsignedInput(num1, num2);
		return num1 >= num2;
	}

	public boolean lessThan(int num1, int num2) {
		validateUnsignedInput(num1, num2);
		return num1 < num2;
	}

	private void validateUnsignedInput(int... nums) {
		for (int num : nums) {
			if (num < 0 || num > 255) {
				throw new IllegalArgumentException("Ongeldige input: getal moet tussen 0 en 255 liggen");
			}
		}
	}
}
