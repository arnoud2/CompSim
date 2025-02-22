package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import domein.LogicParts;

class ComputerPartsTest {

	private LogicParts computerPart = new LogicParts();

	@Test
	void addTest() {
		assertEquals(20, computerPart.add(10, 10));
		assertEquals(182, computerPart.add(27, 155));
		assertEquals(123, computerPart.add(55, 68));
	}

	@Test
	void subtractionTest() {
		assertEquals(0, computerPart.subtract(10, 10));
		assertEquals(-128, computerPart.subtract(27, 155));
		assertEquals(-13, computerPart.subtract(55, 68));
	}

	@Test
	void andGateTest() {
		assertEquals("11111111", computerPart.andGate("11111111", "11111111"));
		assertEquals("10000000", computerPart.andGate("11000011", "10000000"));
		assertEquals("00011011", computerPart.andGate("11011111", "00111011"));
		assertEquals("00000000", computerPart.andGate("00000000", "11111111"));
		assertEquals("11111111", computerPart.andGate("11111111", "11111111"));
	}

	@Test
	void orGateTest() {
		assertEquals("11111111", computerPart.orGate("00001111", "11110000"));
		assertEquals("11111101", computerPart.orGate("11100000", "11111101"));
		assertEquals("11111111", computerPart.orGate("11111111", "01010101"));
		assertEquals("11111111", computerPart.orGate("00000000", "11111111"));
		assertEquals("11111111", computerPart.orGate("11111111", "11111111"));
	}

	@Test
	void notGateTest() {
		assertEquals("10111000", computerPart.notGate("01000111"));
		assertEquals("11110010", computerPart.notGate("00001101"));
		assertEquals("00101100", computerPart.notGate("11010011"));
		assertEquals("11111111", computerPart.notGate("00000000"));
		assertEquals("00000000", computerPart.notGate("11111111"));
	}

	@Test
	void xorGateTest() {
		assertEquals("11110000", computerPart.xorGate("11111111", "00001111"));
		assertEquals("01111101", computerPart.xorGate("11100000", "10011101"));
		assertEquals("10101010", computerPart.xorGate("11111111", "01010101"));
		assertEquals("11111111", computerPart.xorGate("11111111", "00000000"));
		assertEquals("00000000", computerPart.xorGate("11111111", "11111111"));
	}

	@Test
	void rightShiftTest() {
		assertEquals("00000000", computerPart.rightShift("11111111", 8));
		assertEquals("00000001", computerPart.rightShift("11111111", 7));
		assertEquals("00011111", computerPart.rightShift("11111111", 3));
		assertEquals("01100000", computerPart.rightShift("11000000", 1));
	}

	@Test
	void invalidInputTest() {
		assertThrows(IllegalArgumentException.class, () -> computerPart.andGate("110", "10101010"));
		assertThrows(IllegalArgumentException.class, () -> computerPart.orGate("111100001", "00001111"));
		assertThrows(IllegalArgumentException.class, () -> computerPart.xorGate("abcdefgh", "01010101"));
		assertThrows(IllegalArgumentException.class, () -> computerPart.notGate("10101"));
		assertThrows(IllegalArgumentException.class, () -> computerPart.notGate("ABCDEFGH"));
		assertThrows(IllegalArgumentException.class, () -> computerPart.andGate(null, "10101010"));
		assertThrows(IllegalArgumentException.class, () -> computerPart.orGate("", "10101010"));
	}
}
