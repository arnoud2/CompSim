package domein;

public class BinaryFunctions {
	public int binToDec(String binNum) {
		int decNum = 0;
		for (int i = 0; i < 7; i++) {
			decNum += binNum.charAt(i) * Math.pow(2, i);
		}
		return decNum;
	}
}
