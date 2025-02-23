package domein;

public class Coder {

    public int[] parseInstruction(String instruction) {
        String[] parts = instruction.split(" ");
        String operation = parts[0];
        int regA = Integer.parseInt(parts[1]);

        if (operation.equalsIgnoreCase("LDI")) {
            int immediateValue = Integer.parseInt(parts[2]);
            return new int[] { Instruction.LDI.getBinaryCode(), regA, immediateValue, 0 };
        }

        int regB = Integer.parseInt(parts[2]);
        int regC = (parts.length == 4) ? Integer.parseInt(parts[3]) : 0;

        switch (operation.toUpperCase()) {
            case "ADD":
                return new int[] { Instruction.ADD.getBinaryCode(), regA, regB, regC };
            case "SUB":
                return new int[] { Instruction.SUB.getBinaryCode(), regA, regB, regC };
            case "AND":
                return new int[] { Instruction.AND.getBinaryCode(), regA, regB, regC };
            case "OR":
                return new int[] { Instruction.OR.getBinaryCode(), regA, regB, regC };
            case "NOT":
                return new int[] { Instruction.NOT.getBinaryCode(), regA, regB, regC };
            case "XOR":
                return new int[] { Instruction.XOR.getBinaryCode(), regA, regB, regC };
            case "RSH":
                return new int[] { Instruction.RSH.getBinaryCode(), regA, regB, regC };
            case "EQUAL":
                return new int[] { Instruction.EQUAL.getBinaryCode(), regA, regB, regC };
            case "NE":
                return new int[] { Instruction.NOT_EQUAL.getBinaryCode(), regA, regB, regC };
            case "LE":
                return new int[] { Instruction.LESS_OR_EQUAL.getBinaryCode(), regA, regB, regC };
            case "GT":
                return new int[] { Instruction.GREATER_THAN.getBinaryCode(), regA, regB, regC };
            case "GE":
                return new int[] { Instruction.GREATER_OR_EQUAL.getBinaryCode(), regA, regB, regC };
            case "LT":
                return new int[] { Instruction.LESS_THAN.getBinaryCode(), regA, regB, regC };
            case "PACK":
                return new int[] { Instruction.PACK.getBinaryCode(), regA, regB, regC };
            default:
                throw new IllegalArgumentException("Invalid instruction: " + operation);
        }
    }
}
