package domein;

public class LogicParts {

	public String add(int num1, int num2) {
		validateUnsignedInput(num1, num2);
		return decimalToBinary(num1 + num2);
	}

	public String subtract(int num1, int num2) {
		if (num1 > -128 && num1 < 127 && num2 > -128 && num2 < 127) {
			return decimalToBinary(num1 - num2);
		} else {
			throw new IllegalArgumentException("Nummer moet tussen -128 en 127 bevinden");
		}
	}

	public String andGate(int num1, int num2) {
		validateUnsignedInput(num1, num2);
		return applyLogicGate(num1, num2, '&');
	}

	public String orGate(int num1, int num2) {
		validateUnsignedInput(num1, num2);
		return applyLogicGate(num1, num2, '|');
	}

	public String xorGate(int num1, int num2) {
		validateUnsignedInput(num1, num2);
		return applyLogicGate(num1, num2, '^');
	}

	public String notGate(int num) {
		validateUnsignedInput(num);
		return applyLogicGate(num, 0, '!');
	}

	public String rightShift(int num, int positions) {
		if (positions < 0) {
			throw new IllegalArgumentException("Right shift pos mag niet negatief zijn");
		}
		validateUnsignedInput(num);
		int shifted = num >> positions;
		String binaryString = Integer.toBinaryString(shifted);
		while (binaryString.length() < 8) {
			binaryString = "0" + binaryString;
		}
		return binaryString;
	}

	private String applyLogicGate(int num1, int num2, char operation) {
		validateUnsignedInput(num1, num2);
		String binNum1 = decimalToBinary(num1);
		String binNum2 = decimalToBinary(num2);

		StringBuilder result = new StringBuilder(8);
		for (int i = 0; i < 8; i++) {
			char bit1 = binNum1.charAt(i);
			char bit2 = binNum2.charAt(i);
			switch (operation) {
			case '&' -> result.append((bit1 == '1' && bit2 == '1') ? '1' : '0');
			case '|' -> result.append((bit1 == '1' || bit2 == '1') ? '1' : '0');
			case '^' -> result.append((bit1 != bit2) ? '1' : '0');
			case '!' -> result.append((bit1 == '1') ? '0' : '1');
			default -> throw new IllegalArgumentException("Ongeldige operatie");
			}
		}
		return result.toString();
	}

	private void validateUnsignedInput(int... nums) {
		for (int num : nums) {
			if (num < 0 || num > 255) {
				throw new IllegalArgumentException("Ongeldige input: getal moet tussen 0 en 255 liggen");
			}
		}
	}

	static String decimalToBinary(int num) {
		if (num < 0) {
			num += 256;
		}
		return String.format("%8s", Integer.toBinaryString(num)).replace(' ', '0');
	}

	public static int convertBinaryToDecimal(String binaryString) {
		while (binaryString.length() < 8) {
			binaryString = "0" + binaryString;
		}
		return Integer.parseInt(binaryString, 2);
	}
}
