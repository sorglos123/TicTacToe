package cs14_tictactoe;

import java.awt.Dimension;

import javax.swing.*;

public class View extends JFrame {
	public void initialise() {
		//this.setName("Tic Tac Toe");
		setTitle("Tic Tac Toe");
		this.setPreferredSize(new Dimension(800, 800));
		this.pack();
		
		this.setResizable(false);
		this.setLocation(20, 20);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

}
