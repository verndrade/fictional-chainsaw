import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import java.awt.Color;

public class Game implements MouseListener, KeyListener {
	public static void main(String[] args) {
		new Game();
	}

	public Tile[][] panels;
	public final int size = 40;
	JFrame frame;
	int iter = 0;

	public Game() {
		frame = new JFrame();
		frame.setSize(500, 500);
		frame.setLayout(new GridLayout(size, size));

		panels = new Tile[size][size];

		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				panels[r][c] = new Tile();
				panels[r][c].addMouseListener(this);
				frame.add(panels[r][c]);
			}
		}
		frame.addKeyListener(this);
		frame.setVisible(true);
	}

	public void go() {
		Tile[][] tempPanels = new Tile[panels.length][panels.length];
		for (int i = 0; i < panels.length; i++)
			for (int j = 0; j < panels.length; j++) {
				tempPanels[i][j] = new Tile();
				if (panels[i][j].getBackground() == Color.CYAN)
					tempPanels[i][j].swap();
			}
		for (int r = 1; r < size - 1; r++) {
			for (int c = 1; c < size - 1; c++) {
				int result = tempPanels[r - 1][c - 1].id + tempPanels[r - 1][c].id + tempPanels[r - 1][c + 1].id
						+ tempPanels[r][c - 1].id + tempPanels[r][c + 1].id + tempPanels[r + 1][c - 1].id + tempPanels[r + 1][c].id
						+ tempPanels[r + 1][c + 1].id;
				if (result < 2 || result > 3)
					panels[r][c].die();
				else if (result == 3)
					panels[r][c].live();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		((Tile) e.getSource()).swap();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getID() == 400) {
			go();
			iter++;
			frame.setTitle("" + iter);
		}

	}

}
