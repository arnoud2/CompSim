package cui;

import domein.Domein;
import domein.Coder;

public class Program {

    private Domein dc;
    private Coder coder;

    public Program(Domein domein) {
        this.dc = domein;
        this.coder = new Coder();
    }
    
    public void startUp() {
    	
    	String[] code = {
    	    "LDI 1 6",   // reg1 = 6
    	    "LDI 2 5",   // reg2 = 5
    	    "LDI 13 1",  // reg13 = 1
    	    "LDI 14 4",  // regjump = 4
    	    "ADD 3 1 3",   // reg3 += reg1
    	    "ADD 12 13 12",// reg12 = counter++
    	    "NE 12 2 0"    // reg12 != reg2 then jump
    	};

        int pc = 0;
        
        while (pc < code.length) {
            String instruction = code[pc];
            int[] parsed = coder.parseInstruction(instruction);

            int opcode = parsed[0];
            int regA = parsed[1];
            int regB = parsed[2];
            int regC = parsed[3];

            if (opcode < 8) {
                dc.runLineOfCodeLogic(opcode, regA, regB, regC);
                pc += 1;
            } else if (opcode < 14) {
                int jump = dc.runLineOfCodeJump(opcode, regA, regB);
                pc = (jump != -1) ? jump : (pc + 1);
            }
            if (opcode == 14) {
                dc.ldi(regA, regB);
                pc += 1;
            }
            if (opcode == 15) {
                dc.pack(regA, regB);
                pc += 1;
            }
        }
        dc.printReg();
    }
}
