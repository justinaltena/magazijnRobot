package Robot;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class TSPPanel extends JPanel {

    private int prevProductX, prevProductY;
    private ArrayList<Product> productsT = new ArrayList<>();
    private RobotStart exec;

    public TSPPanel() {
    }

    public void setExec(RobotStart exec) {
        this.exec = exec;
//        System.out.println("exec in tsppanel = " + this.exec);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
        g.setColor(Color.black);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(6));
        //OMLIJNING GRID
        g2.draw(new Rectangle2D.Float(10, 10, 810, 511));
        //HORIZONTALE LIJNEN GRID
        g2.draw(new Line2D.Float(10, 177, 820, 177));
        g2.draw(new Line2D.Float(10, 344, 820, 344));
        //VERTICALE LIJNEN GRID
        g2.draw(new Line2D.Float(170, 10, 170, 520));
        g2.draw(new Line2D.Float(330, 10, 330, 520));
        g2.draw(new Line2D.Float(490, 10, 490, 520));
        g2.draw(new Line2D.Float(650, 10, 650, 520));

        //TEKENEN PAKKETTEN NA LADEN ORDER
        try {
            if (!exec.getProductsR().isEmpty()) {
                for (Product pd : exec.getProductsR()) {
                    int px = pd.getProductX();
                    int x = convertX(px);
                    int py = pd.getProductY();
                    int y = convertY(py);
                    drawProduct(g, x, y);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Kan niet repainten, array is leeg");
        }

        try {
            drawRoute(g, exec.getTSPvolgorde());
        } catch (NullPointerException e) {
            System.out.println("TSPvolgorde net voor tekenen is leeg");
        }
    }

    public void drawProduct(Graphics g, float x, float y) {
        Graphics2D g3 = (Graphics2D) g;
        g3.setColor(Color.BLUE);
        g3.setStroke(new BasicStroke(5));
        g3.draw(new Line2D.Float(x, y, (x + 160), (y + 167)));
        g3.draw(new Line2D.Float((x + 160), y, x, (y + 167)));

    }

    public void drawRoute(Graphics g, ArrayList<Product> coor) {
        Graphics2D g4 = (Graphics2D) g;
        g4.setColor(Color.RED);
        g4.setStroke(new BasicStroke(3));

        Point prevCoor, nextCoor;
        int prevX, prevY, nextX, nextY;
        int start = 0;
        int einde = 0;
        for (int i = 0; i < (exec.getTSPvolgorde().size()) - 1; i++) {
            prevCoor = exec.getTSPvolgorde().get(i).getProduct_position();
            nextCoor = exec.getTSPvolgorde().get(i + 1).getProduct_position();
            prevX = convertX((int) prevCoor.getX()) + 80;
            prevY = convertY((int) prevCoor.getY()) + 84;
            nextX = convertX((int) nextCoor.getX()) + 80;
            nextY = convertY((int) nextCoor.getY()) + 84;
            while (start == 0) {
                g4.setColor(Color.GREEN);
                g4.fillOval((prevX - 20), (prevY - 20), 40, 40);
                start = 1;
                g4.setColor(Color.RED);
            }
            while (einde == 0 && i == (exec.getTSPvolgorde().size()) - 2) {
                g4.fillOval((nextX - 20), (nextY - 20), 40, 40);
                einde = 1;
            }
            if ((i + 1) % 3 == 0) {
                g4.draw(new Line2D.Double(prevX, prevY, 10, 530));
                g4.draw(new Line2D.Double(10, 530, nextX, nextY));
            } else {
                g4.draw(new Line2D.Double(prevX, prevY, nextX, nextY));
            }
        }

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
