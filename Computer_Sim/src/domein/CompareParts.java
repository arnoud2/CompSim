package domein;

public class CompareParts {

    public boolean equal(int num1, int num2) {
        return validateUnsignedInput(num1, num2) && num1 == num2;
    }

    public boolean notEqual(int num1, int num2) {
        return validateUnsignedInput(num1, num2) && num1 != num2;
    }

    public boolean lessOrEqual(int num1, int num2) {
        return validateUnsignedInput(num1, num2) && num1 <= num2;
    }

    public boolean greaterThan(int num1, int num2) {
        return validateUnsignedInput(num1, num2) && num1 > num2;
    }

    public boolean greaterOrEqual(int num1, int num2) {
        return validateUnsignedInput(num1, num2) && num1 >= num2;
    }

    public boolean lessThan(int num1, int num2) {
        return validateUnsignedInput(num1, num2) && num1 < num2;
    }

    private boolean validateUnsignedInput(int num1, int num2) {
        if (num1 < 0 || num1 > 255 || num2 < 0 || num2 > 255) {
            throw new IllegalArgumentException("Ongeldige input: getal moet tussen 0 en 255 liggen");
        }
        return true;
    }
}