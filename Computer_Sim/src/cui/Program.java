package cui;

import domein.Domein;

public class Program {

    private Domein dc;

    public Program(Domein domein) {
        this.dc = domein;
    }

    public void startUp() {
        int[] code = 
        	{
        	14, 1, 0, 21,  //reg1 = 6
        	14, 2, 0, 9,   //reg2 = 5
        	14, 13, 0, 1,  //reg13 = con 1
        	14, 14, 0, 5,  //regjump = 5
        	1, 3, 1, 3 ,   //reg3 += reg1
        	1, 12, 13, 12, //reg12 = counter++
        	9, 12, 2, 0    //reg12 != reg2 then jump
        	};
        
        int pc = 0;

        while (pc < code.length) {
            int opcode = code[pc];
            int regA = code[pc + 1];
            int regB = code[pc + 2];
            int regC = code[pc + 3];

            if (opcode < 8) {
                dc.runLineOfCodeLogic(opcode, regA, regB, regC);
                pc += 4;
            } else if (opcode < 14) {
                int jump = dc.runLineOfCodeJump(opcode, regA, regB);
                pc = (jump != -1) ? jump : (pc + 4);
            }
            if (opcode == 14) {
                dc.ldi(regA, regB, regC);
            	pc += 4;
            }
            if (opcode == 15) {
                dc.pack(regA, regB);
            	pc += 4;
            }
        }

        dc.printReg();
    }
}
