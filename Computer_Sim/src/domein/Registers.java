package domein;

public class Registers {
	private int[] registers;

	public Registers() {
		registers = new int[16];
	}

	public int getRegister(int index) {
		if (index < 0 || index >= registers.length) {
			throw new IllegalArgumentException("Ongeldeige bereik voor registers");
		}
		return registers[index];
	}

	public void setRegister(int value, int index) {
		if (index < 0 || index >= registers.length) {
			throw new IllegalArgumentException("Ongeldeige bereik voor registers");
		}
		if (index == 0) {
			return;
		}
		registers[index] = value;
	}

	public void printRegisters() {
		for (int i = 1; i < registers.length; i++) {
			System.out.println("Register " + i + ": " + registers[i]);
		}
	}
}
