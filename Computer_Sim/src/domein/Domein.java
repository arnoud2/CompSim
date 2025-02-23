package domein;

public class Domein {

    private LogicParts lp = new LogicParts();
    private CompareParts cp = new CompareParts();
    private Registers reg = new Registers();
    
    public void runLineOfCodeLogic(int opcode, int regA, int regB, int regC) {
    	regA = reg.getRegister(regA);
    	regB = reg.getRegister(regB);
        int result;
        switch (opcode) {
            case 1: result = lp.add(regA, regB); break;
            case 2: result = lp.subtract(regA, regB); break;
            case 3: result = lp.andGate(regA, regB); break;
            case 4: result = lp.orGate(regA, regB); break;
            case 5: result = lp.notGate(regA); break;
            case 6: result = lp.xorGate(regA, regB); break;
            case 7: result = lp.rightShift(regA, regB); break;
            default: throw new IllegalArgumentException("Invalid opcode: " + opcode);
        }
        reg.setRegister(result, regC);
    }

    public int runLineOfCodeJump(int opcode, int regA, int regB) {
    	regA = reg.getRegister(regA);
    	regB = reg.getRegister(regB);
    	boolean result;
        switch (opcode) {
            case 8: result = cp.equal(regA, regB); break;
            case 9: result = cp.notEqual(regA, regB); break;
            case 10: result = cp.lessOrEqual(regA, regB); break;
            case 11: result = cp.greaterThan(regA, regB); break;
            case 12: result = cp.greaterOrEqual(regA, regB); break;
            case 13: result = cp.lessThan(regA, regB); break;
            default: throw new IllegalArgumentException("Invalid jump opcode: " + opcode);
        }
        if (result)
            return reg.getRegister(14);
        else
        	return -1;
    }
    
    public void ldi(int regA, int immediateValue) {
        reg.setRegister(immediateValue, regA);
    }

    public void pack (int regA, int regB) {
    	reg.setRegister(reg.getRegister(regB), regA);
    }
    
    public void printReg() {
		reg.printRegisters();
	}
}