import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;

public class Tile extends JPanel {
  public int id = 0;

  public Tile() {
    this.setBackground(Color.GRAY);
    this.setBorder(BorderFactory.createLineBorder(Color.black));
  }

  public void swap() {
    if (this.getBackground() == Color.GRAY) {
      live();
    } else {
      die();
    }
  }

  public void die() {
    this.setBackground(Color.GRAY);
    id = 0;
  }

  public void live() {
    this.setBackground(Color.CYAN);
    id = 1;
  }
}
