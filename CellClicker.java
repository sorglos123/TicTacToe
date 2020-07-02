package cs14_tictactoe;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class CellClicker extends MouseAdapter {
	Model m;
	Board view;

	public void initialise(Board b, Model m) {
		this.m = m;
		this.view = b;

	}

	public void mouseClicked(MouseEvent e) {

		super.mouseClicked(e);
		int i = -1;
		int j = -1;
		System.out.println("click");

		Point p = e.getPoint();
		//this.view.adjust();
		//System.out.println(this.view.upperLeftCorner.y);

		if (p.getY() >= this.view.upperLeftCorner.getY()) {
			i = (p.y - this.view.upperLeftCorner.y) / this.view.sideLength;

		}
		if (p.getX() >= this.view.upperLeftCorner.getX()) {
			j = (p.x - this.view.upperLeftCorner.x) / this.view.sideLength;
		}
		if ((i >= 0 && i < this.m.size) && (j >= 0 && j < this.m.size)) {

		    this.m.take(j, i);

		    this.view.repaint();
		    System.out.println(this.m.cells[j][i].toString());
		}
		if(m.isFinished()) {
			JOptionPane.showMessageDialog(null, "Das Spiel wurde beendet");
			
		}
	}

}
