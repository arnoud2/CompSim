package domein;

public class Registers {
    private final int[] registers = new int[16];

    public int getRegister(int index) {
        if (index < 0 || index >= registers.length) 
            throw new IllegalArgumentException("Ongeldige bereik voor registers");
        return registers[index];
    }

    public void setRegister(int value, int index) {
        if (index < 0 || index >= registers.length) 
            throw new IllegalArgumentException("Ongeldige bereik voor registers");
        if (value < -128 || value > 255) 
            throw new IllegalArgumentException("Waarde moet tussen -128 en 255 liggen");
        if (index == 0) return;
        registers[index] = value;
    }

    public void printRegisters() {
        for (int i = 1; i < registers.length; i++) 
            System.out.println("Register " + i + ": " + registers[i]);
    }
}
