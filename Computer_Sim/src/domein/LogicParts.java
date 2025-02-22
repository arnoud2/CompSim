package domein;

public class LogicParts {

	public int add(int num1, int num2) {
		return num1 + num2;
	}

	public int subtract(int num1, int num2) {
		return num1 - num2;
	}

	public String andGate(String num1, String num2) {
		validateBinaryInput(num1, num2);
		return applyLogicGate(num1, num2, '&');
	}

	public String orGate(String num1, String num2) {
		validateBinaryInput(num1, num2);
		return applyLogicGate(num1, num2, '|');
	}

	public String xorGate(String num1, String num2) {
		validateBinaryInput(num1, num2);
		return applyLogicGate(num1, num2, '^');
	}

	public String notGate(String num) {
		validateBinaryInput(num);
		return applyLogicGate(num, null, '!');
	}

	public String rightShift(String num, int positions) {
		validateBinaryInput(num);
		return "0".repeat(positions) + num.substring(0, num.length() - positions);
	}

	private String applyLogicGate(String num1, String num2, char operation) {
		StringBuilder result = new StringBuilder(8);
		for (int i = 0; i < 8; i++) {
			char bit1 = num1.charAt(i);
			char bit2 = (num2 != null) ? num2.charAt(i) : '0';
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

	private void validateBinaryInput(String... nums) {
		for (String num : nums) {
			if (num == null || !num.matches("[01]{8}")) {
				throw new IllegalArgumentException("Ongeldige input");
			}
		}
	}
}
