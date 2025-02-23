package cui;

import domein.Domein;

public class Program {

    private Domein dc = new Domein();

    public void startUp() {
        int[] code = { 1, 1, 2, 3};
        int pc = 0;

        while (pc < code.length) {
            int opcode = code[pc];
            int regA = code[pc + 1];
            int regB = code[pc + 2];
            int regC = code[pc + 3];

            if (opcode < 8) {
                dc.runLineOfCodeLogic(opcode, regA, regB, regC);
                pc += 4;
            } 
            else if(opcode < 14){
                int jump = dc.runLineOfCodeJump(opcode, regA, regB);
                pc = (jump != -1) ? jump : (pc + 4); 
            }
            if (opcode == 14)
            	dc.ldi(regA, regB, regC);
            
            if (opcode == 15)
            	dc.pack(regA, regB);
        }
    }
}
