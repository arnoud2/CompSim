package main;

import cui.Program;
import domein.Domein;

public class PcApplication {
    public static void main(String[] args) {
        Domein dc = new Domein();
        Program program = new Program(dc);
        program.startUp();
    }
}
