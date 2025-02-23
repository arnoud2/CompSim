package domein;

public class LogicParts {

	public int add(int num1, int num2) {
		validateUnsignedInput(num1, num2);
		return num1 + num2;
	}

	public int subtract(int num1, int num2) {
		if (num1 > -128 && num1 < 127 && num2 > -128 && num2 < 127) {
			return num1 - num2;
		} else {
			throw new IllegalArgumentException("Nummer moet tussen -128 en 127 bevinden");
		}
	}

	public int andGate(int num1, int num2) {
		validateUnsignedInput(num1, num2);
		return applyLogicGate(num1, num2, '&');
	}

	public int orGate(int num1, int num2) {
		validateUnsignedInput(num1, num2);
		return applyLogicGate(num1, num2, '|');
	}

	public int xorGate(int num1, int num2) {
		validateUnsignedInput(num1, num2);
		return applyLogicGate(num1, num2, '^');
	}

	public int notGate(int num) {
		validateUnsignedInput(num);
		return applyLogicGate(num, 0, '!');
	}

	public int rightShift(int num, int positions) {
		if (positions < 0) {
			throw new IllegalArgumentException("Right shift pos mag niet negatief zijn");
		}
		validateUnsignedInput(num);
		int shifted = num >> positions;
		String binaryString = Integer.toBinaryString(shifted);
		while (binaryString.length() < 8) {
			binaryString = "0" + binaryString;
		}
		return Integer.parseInt(binaryString, 2);
	}

	private int applyLogicGate(int num1, int num2, char operation) {
		String binNum1 = String.format("%8s", Integer.toBinaryString(num1)).replace(' ', '0');
		String binNum2 = String.format("%8s", Integer.toBinaryString(num2)).replace(' ', '0');

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
		return Integer.parseInt(result.toString(), 2);
	}

	private void validateUnsignedInput(int... nums) {
		for (int num : nums) {
			if (num < 0 || num > 255) {
				throw new IllegalArgumentException("Ongeldige input: getal moet tussen 0 en 255 liggen");
			}
		}
	}
}
