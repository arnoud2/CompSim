package domein;

public class SpecialFunctions {
	
    public int immediate(int num1, int num2) {
        String binDec1 = String.format("%4s", Integer.toBinaryString(num1)).replace(' ', '0');
        String binDec2 = String.format("%4s", Integer.toBinaryString(num2)).replace(' ', '0');
        String binDec12 = binDec1 + binDec2;
        return Integer.parseInt(binDec12, 2);
    }
}
