package Robot;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class BPPPanel extends JPanel {

    public BPPPanel() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
    }
}
