package domein;

public class BinaryFunctions {

	public int binToDec(String binNum) {
		int decNum = 0;
		for (int i = 0; i < 8; i++) {
			if (binNum.charAt(8 - 1 - i) == '1') {
				decNum += Math.pow(2, i);
			}
		}
		return decNum;
	}
}
