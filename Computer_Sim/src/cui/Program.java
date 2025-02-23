package cui;

import domein.Domein;

public class Program {

	private Domein dc = new Domein();

	public void startUp() {

		int[] code = { 1, 1, 2, 3 };

		for (int i = 0; i < code.length / 4; i += 4) {
			dc.runLineOfCode(code[i], code[i + 1], code[i + 2], code[i + 3]);
		}
	}
}
