package domein;

public class CompareParts {

	public boolean equal(int num1, int num2) {
		validateUnsignedInput(num1, num2);
		if (num1 == num2) {
			return true;
		} else {
			return false;
		}
	}

	public boolean notEqual(int num1, int num2) {
		validateUnsignedInput(num1, num2);
		return !equal(num1, num2);
	}

	public boolean lessOrEqual(int num1, int num2) {
		if (equal(num1, num2) || lessThen(num1, num2)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean greaterThen(int num1, int num2) {
		return !lessOrEqual(num1, num2);
	}

	public boolean greaterOrEqual(int num1, int num2) {
		if (greaterThen(num1, num2) || equal(num1, num2)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean lessThen(int num1, int num2) {
		validateUnsignedInput(num1, num2);
		if (num1 < num2) {
			return true;
		} else {
			return false;
		}
	}

	private void validateUnsignedInput(int... nums) {
		for (int num : nums) {
			if (num < 0 || num > 255) {
				throw new IllegalArgumentException("Ongeldige input: getal moet tussen 0 en 255 liggen");
			}
		}
	}
}