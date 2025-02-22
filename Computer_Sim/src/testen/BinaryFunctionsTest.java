package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domein.BinaryFunctions;

class BinaryFunctionsTest {

	@Test
	void testBinToDec() {
		BinaryFunctions binaryFunctions = new BinaryFunctions();

		assertEquals(10, binaryFunctions.binToDec("00001010"));
		assertEquals(7, binaryFunctions.binToDec("00000111"));
		assertEquals(94, binaryFunctions.binToDec("01011110"));
		assertEquals(0, binaryFunctions.binToDec("00000000"));
		assertEquals(255, binaryFunctions.binToDec("11111111"));
	}
}
