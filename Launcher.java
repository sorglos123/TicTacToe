package cs14_tictactoe;

import java.awt.Dimension;
import java.io.File;

import javax.swing.*;

public class Launcher extends JFrame {

	public static void main(String[] args) {
		Player starter = Player.CROSS;
		int size = 3;
		if (args.length != 0) {
			size = Integer.parseInt(args[0]);

			if (args[1].equals("naught")) {
				starter = Player.NAUGHT;
			}
		}

		// View v = new View();
		JFrame frame = new JFrame("Tic Tac Toe");

		Model m = new Model();
		CellClicker c = new CellClicker();
		Board b = new Board();

		m.initialise(size, starter);
		b.initialise(m, c);
		c.initialise(b, m);

		frame.add(b);

		frame.setPreferredSize(new Dimension(800, 800));
		frame.pack();
		frame.setResizable(false);
		frame.setLocation(20, 20);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("cs14_tictactoe" + File.separator + "icon.png").getImage());
		frame.setVisible(true);

		b.adjust();

	}

}
