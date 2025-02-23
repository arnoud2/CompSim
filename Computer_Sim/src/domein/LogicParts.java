package domein;

public class LogicParts {

    public int add(int num1, int num2) {
        validateUnsignedInput(num1, num2);
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        validateRange(num1, num2);
        return num1 - num2;
    }

    public int andGate(int num1, int num2) {
        return applyLogicGate(num1, num2, '&');
    }

    public int orGate(int num1, int num2) {
        return applyLogicGate(num1, num2, '|');
    }

    public int xorGate(int num1, int num2) {
        return applyLogicGate(num1, num2, '^');
    }

    public int notGate(int num) {
        return applyLogicGate(num, 0, '!');
    }

    public int rightShift(int num, int positions) {
        if (positions < 0) throw new IllegalArgumentException("Right shift pos mag niet negatief zijn");
        validateUnsignedInput(num);
        return Integer.parseInt(Integer.toBinaryString(num >> positions), 2);
    }

    private int applyLogicGate(int num1, int num2, char operation) {
        validateUnsignedInput(num1, num2);
        String binNum1 = formatBinary(num1), binNum2 = formatBinary(num2);
        StringBuilder result = new StringBuilder(8);

        for (int i = 0; i < 8; i++) {
            char bit1 = binNum1.charAt(i), bit2 = binNum2.charAt(i);
            result.append(switch (operation) {
                case '&' -> (bit1 == '1' && bit2 == '1') ? '1' : '0';
                case '|' -> (bit1 == '1' || bit2 == '1') ? '1' : '0';
                case '^' -> (bit1 != bit2) ? '1' : '0';
                case '!' -> (bit1 == '1') ? '0' : '1';
                default -> throw new IllegalArgumentException("Ongeldige operatie");
            });
        }
        return Integer.parseInt(result.toString(), 2);
    }

    private String formatBinary(int num) {
        return String.format("%8s", Integer.toBinaryString(num)).replace(' ', '0');
    }

    private void validateUnsignedInput(int... nums) {
        for (int num : nums) {
            if (num < 0 || num > 255) throw new IllegalArgumentException("Ongeldige input: getal moet tussen 0 en 255 liggen");
        }
    }

    private void validateRange(int num1, int num2) {
        if (num1 < -128 || num1 > 127 || num2 < -128 || num2 > 127)
            throw new IllegalArgumentException("Nummer moet tussen -128 en 127 bevinden");
    }
}