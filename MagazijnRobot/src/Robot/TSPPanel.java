package Robot;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class TSPPanel extends JPanel {

    private int prevProductX, prevProductY;

    public TSPPanel() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
        g.setColor(Color.black);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(6));
        //OMLIJNING
        g2.draw(new Rectangle2D.Float(10, 10, 810, 511));
        //HORIZONTAAL
        g2.draw(new Line2D.Float(10, 177, 820, 177));
        g2.draw(new Line2D.Float(10, 344, 820, 344));
        //VERTICAAL
        g2.draw(new Line2D.Float(170, 10, 170, 520));
        g2.draw(new Line2D.Float(330, 10, 330, 520));
        g2.draw(new Line2D.Float(490, 10, 490, 520));
        g2.draw(new Line2D.Float(650, 10, 650, 520));

        try {
            System.out.println("Start van for-loop");
            //TEKENEN PAKKETTEN NA LADEN ORDER
            for (Product pd : RobotStart.products) {
                int px = pd.getProductX();
                int x = convertX(px);
                int py = pd.getProductY();
                int y = convertY(py);
                drawProduct(g, x, y);
                System.out.println("Gelukt Tekenen");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Product pt : RobotStart.TSPvolgorde) {
            int x = convertX(pt.getProductX());
            int y = convertY(pt.getProductY());

        }
    }

    public void drawProduct(Graphics g, float x, float y) {
        Graphics2D g3 = (Graphics2D) g;
        g3.setColor(Color.RED);
        g3.setStroke(new BasicStroke(5));
        g3.draw(new Line2D.Float(x, y, (x + 160), (y + 167)));
        g3.draw(new Line2D.Float((x + 160), y, x, (y + 167)));

    }

    public void drawRoute(Graphics g, int x1, int y1) {
        Graphics2D g4 = (Graphics2D) g;
        g4.setColor(Color.LIGHT_GRAY);
        g4.setStroke(new BasicStroke(3));

    }

    public void drawRoute(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g5 = (Graphics2D) g;
        g5.setColor(Color.LIGHT_GRAY);
        g5.setStroke(new BasicStroke(3));

    }

    public int convertX(int px) {
        int x;
        switch (px) {
            case 1:
                x = 10;
                break;
            case 2:
                x = 170;
                break;
            case 3:
                x = 330;
                break;
            case 4:
                x = 490;
                break;
            case 5:
                x = 650;
                break;
            default:
                x = 0;
        }
        return x;

    }

    public int convertY(int py) {
        int y;
        switch (py) {
            case 1:
                y = 10;
                break;
            case 2:
                y = 177;
                break;
            case 3:
                y = 344;
                break;
            case 4:
                y = 511;
                break;
            default:
                y = 0;
        }
        return y;
    }
}
