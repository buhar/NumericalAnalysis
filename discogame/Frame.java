import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Frame extends JFrame {

	private Cell[][] cells = new Cell[6][6];
	private int[][] L1 = new int[][]{{1,1,0,0,0,0},{1,0,0,0,0,1},{0,0,0,0,1,1},{0,1,0,0,0,1},{1,1,1,0,0,0},{0,1,0,0,0,0}};
	JLabel label = new JLabel("");

	public Frame() {
		JPanel panel = new JPanel(new GridLayout(6, 6));
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 6; j++){
				cells[i][j] = new Cell(i, j);
				if(L1[i][j] == 1){
					cells[i][j].setColor();
				}
				panel.add(cells[i][j]);
			}
		add(panel, BorderLayout.CENTER);
		add(label,BorderLayout.SOUTH);
	}

	public boolean isGameOver() {
		for (Cell[] row : cells) {
			for (Cell c : row) {
				if (c.getColor()) {
					return false;
				}
			}
		}
		return true;
	}

	public class Cell extends JPanel {
		private boolean color;
		private int i, j;

		public Cell(int i, int j) {
			setBorder(new LineBorder(Color.black, 1));
			addMouseListener(new MyMouseListener());
			this.i = i;
			this.j = j;
		}

		public int getI() {
			return i;
		}

		public int getJ() {
			return j;
		}

		public void setColor() {
			color = !color;
			repaint();
		}

		public boolean getColor() {
			return color;
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (color == true) {
				g.setColor(Color.red);
				g.fillRect(0, 0, getWidth(), getHeight());
			}
	
			else if (color == false) {
				g.setColor(Color.gray);
				g.fillRect(0, 0, getWidth(), getHeight());
			}
		}

		private class MyMouseListener extends MouseAdapter {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cell c = (Cell) e.getComponent();
				c.setColor();
				try{
					Cell cN = cells[c.getI() - 1][c.getJ()];
					cN.setColor();
				}catch(ArrayIndexOutOfBoundsException ex){}
				try{
					Cell cS = cells[c.getI() + 1][c.getJ()];
					cS.setColor();
				}catch(ArrayIndexOutOfBoundsException ex){}
				try{
					Cell cW = cells[c.getI()][c.getJ() - 1];
					cW.setColor();
				}catch(ArrayIndexOutOfBoundsException ex){}
				try{
					Cell cE = cells[c.getI()][c.getJ() + 1];
					cE.setColor();
				}catch(ArrayIndexOutOfBoundsException ex){}
				
				if(isGameOver())
				{
					label.setText(" Game over!");
					JOptionPane.showMessageDialog(null, "GAME OVER!");
				}
			}
		}
	}

}
