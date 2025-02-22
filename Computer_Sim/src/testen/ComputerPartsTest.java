package testen;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domein.LogicParts;

class ComputerPartsTest {

	private LogicParts computerPart = new LogicParts();

	@Test
	void addTest() {
		assertEquals("00010100", computerPart.add(10, 10));
		assertEquals("10110110", computerPart.add(27, 155));
		assertEquals("01111011", computerPart.add(55, 68));
	}

	@Test
	void subtractionTest() {
		assertEquals("00000000", computerPart.subtract(10, 10));
		assertEquals("10100001", computerPart.subtract(27, 122));
		assertEquals("11110011", computerPart.subtract(55, 68));
	}

	@Test
	void andGateTest() {
		assertEquals("11111111", computerPart.andGate(255, 255));
		assertEquals("10000000", computerPart.andGate(195, 128));
		assertEquals("00011011", computerPart.andGate(223, 59));
		assertEquals("00000000", computerPart.andGate(0, 255));
		assertEquals("11111111", computerPart.andGate(255, 255));
	}

	@Test
	void orGateTest() {
		assertEquals("11111111", computerPart.orGate(15, 240));
		assertEquals("11111101", computerPart.orGate(192, 253));
		assertEquals("11111111", computerPart.orGate(255, 85));
		assertEquals("11111111", computerPart.orGate(0, 255));
		assertEquals("11111111", computerPart.orGate(255, 255));
	}

	@Test
	void notGateTest() {
		assertEquals("11011000", computerPart.notGate(39));
		assertEquals("11110010", computerPart.notGate(13));
		assertEquals("00101100", computerPart.notGate(211));
		assertEquals("11111111", computerPart.notGate(0));
		assertEquals("00000000", computerPart.notGate(255));
	}

	@Test
	void xorGateTest() {
		assertEquals("11110000", computerPart.xorGate(255, 15));
		assertEquals("01011101", computerPart.xorGate(192, 157));
		assertEquals("10101010", computerPart.xorGate(255, 85));
		assertEquals("11111111", computerPart.xorGate(255, 0));
		assertEquals("00000000", computerPart.xorGate(255, 255));
	}

	@Test
	void rightShiftTest() {
		assertEquals("00000000", computerPart.rightShift(255, 8));
		assertEquals("00000001", computerPart.rightShift(255, 7));
		assertEquals("00000000", computerPart.rightShift(0, 3));
		assertEquals("01100000", computerPart.rightShift(192, 1));
	}

	@Test
	public void testAddInvalidInput() {
		assertThrows(IllegalArgumentException.class, () -> computerPart.add(-1, 10));
		assertThrows(IllegalArgumentException.class, () -> computerPart.add(10, 256));
	}

	@Test
	public void testSubtractInvalidInput() {
		assertThrows(IllegalArgumentException.class, () -> computerPart.subtract(-333, 10));
		assertThrows(IllegalArgumentException.class, () -> computerPart.subtract(10, 256));
	}

	@Test
	public void testAndGateInvalidInput() {
		assertThrows(IllegalArgumentException.class, () -> computerPart.andGate(-1, 10));
		assertThrows(IllegalArgumentException.class, () -> computerPart.andGate(10, 256));
	}

	@Test
	public void testOrGateInvalidInput() {
		assertThrows(IllegalArgumentException.class, () -> computerPart.orGate(-1, 10));
		assertThrows(IllegalArgumentException.class, () -> computerPart.orGate(10, 256));
	}

	@Test
	public void testXorGateInvalidInput() {
		assertThrows(IllegalArgumentException.class, () -> computerPart.xorGate(-1, 10));
		assertThrows(IllegalArgumentException.class, () -> computerPart.xorGate(10, 256));
	}

	@Test
	public void testNotGateInvalidInput() {
		assertThrows(IllegalArgumentException.class, () -> computerPart.notGate(-1));
		assertThrows(IllegalArgumentException.class, () -> computerPart.notGate(256));
	}

	@Test
	public void testRightShiftInvalidInput() {
		assertThrows(IllegalArgumentException.class, () -> computerPart.rightShift(1, -3));
		assertThrows(IllegalArgumentException.class, () -> computerPart.rightShift(256, 4));
	}
}
