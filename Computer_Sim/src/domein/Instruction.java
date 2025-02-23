package domein;

public enum Instruction {
    NOP(0, "NOP", "No operation"),
    ADD(1, "ADD", "A + B → C"),
    SUB(2, "SUB", "A - B → C"),
    AND(3, "AND", "AB → C"),
    OR(4, "OR", "A + B → C"),
    NOT(5, "NOT", "-A → C"),
    XOR(6, "XOR", "(A * B̅) + (A̅ * B) → C"),
    RSH(7, "RSH", "A (B) >> C"),
    EQUAL(8, "EQUAL", "IF (A == B) → jump"),
    NOT_EQUAL(9, "NOT EQUAL", "IF (A != B) → jump"),
    LESS_OR_EQUAL(10, "LESS OR EQUAL", "IF (A <= B) → jump"),
    GREATER_THAN(11, "GREATER THAN", "IF (A > B) → jump"),
    GREATER_OR_EQUAL(12, "GREATER OR EQUAL", "IF (A >= B) → jump"),
    LESS_THAN(13, "LESS THAN", "IF (A < B) → jump"),
    LDI(14, "LDI", "Immediate → A"),
    PACK(15, "PACK", "A → Val B → Address");
	
    private final int opcode;
    private final String name;
    private final String description;

    Instruction(int opcode, String name, String description) {
        this.opcode = opcode;
        this.name = name;
        this.description = description;
    }
    
    public int getBinaryCode() {
        return opcode;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
};

