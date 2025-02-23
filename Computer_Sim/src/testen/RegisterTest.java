package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import domein.Registers;

class RegisterTest {

	private Registers registers = new Registers();

	@Test
	void setGetRegisterTest() {
		registers.setRegister(5, 1);
		assertEquals(5, registers.getRegister(1));

		registers.setRegister(10, 2);
		assertEquals(10, registers.getRegister(2));

		registers.setRegister(100, 0);
		assertEquals(0, registers.getRegister(0));
	}

	@Test
	void invalidIndexTest() {
		assertThrows(IllegalArgumentException.class, () -> registers.setRegister(20, 16));
		assertThrows(IllegalArgumentException.class, () -> registers.getRegister(-1));
		assertThrows(IllegalArgumentException.class, () -> registers.getRegister(16));
	}

	@Test
	void printRegistersTest() {
		registers.setRegister(1, 1);
		registers.setRegister(2, 2);
		registers.printRegisters();
	}
}
