package cs14_tictactoe;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Board extends JComponent {
	Model model;
	int sideLength;
	java.awt.Point upperLeftCorner;

	public void initialise(Model m, CellClicker c) {
		this.addMouseListener(c);
		this.model = m;

		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	public void adjust() {
		Dimension d = getSize();
		int min = Math.min(d.height, d.width);
		this.sideLength = min / this.model.size;
		this.upperLeftCorner = getLocation();

	}

	
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		for (int i = 0; i < this.model.size; i++) {
			for (int j = 0; j < this.model.size; j++) {
				int x = this.upperLeftCorner.x + i * this.sideLength;
				int y = this.upperLeftCorner.y + j * this.sideLength;
				g.drawRect(x, y, this.sideLength, this.sideLength);
				Cell c = this.model.cells[i][j];
				Rectangle r = new Rectangle(x, y, this.sideLength, this.sideLength);
				drawSign(g, r, c.getPlayer());
			}

		}
	}

	private void drawSign(Graphics g, Rectangle r, Player player) {
		if (player == Player.NAUGHT) {
			drawNaught(g, r);
		} else if (player == Player.CROSS) {
			drawCross(g, r);
		}

	}

	public void drawCross(Graphics g, Rectangle r) {
		System.out.println("draw cross");
		int o = 20;
		g.drawLine(r.x + o, r.y + o, r.x + r.width - o, r.y + r.height - o);
		g.drawLine(r.x + r.width - o, r.y + o, r.x + o, r.y + r.height - o);
		
	}

	public void drawNaught(Graphics g, Rectangle r) {
		int o = 20;
		g.drawOval(r.x + o, r.y + o, r.width - o * 2, r.height - o * 2);
		
	}

}
