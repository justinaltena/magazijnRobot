package Robot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class BPPPanel extends JPanel {

    private RobotStart exec;
    private Point bLinksBoven;
    private Point bLinksOnder;
    private Point bRechtsBoven;
    private Point bRechtsOnder;

    public BPPPanel() {

    }

    public void setExec(RobotStart exec) {
        this.exec = exec;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
        g.setColor(Color.black);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));
        //HET TEKENEN VAN LEGE BINS
        try {
            drawBins(g2);
            //System.out.println("na aanroepen drawBins = " + exec.getBins().get(0));
        } catch (NullPointerException e) {
            System.out.println("Er zitten nog geen producten in de bins");
        }

    }

    private void drawBins(Graphics2D g2) {
        //LIJNEN VOOR 1 BIN
        bLinksBoven = new Point(8, 10);
        bLinksOnder = new Point(8, 302);
        bRechtsBoven = new Point(172, 10);
        bRechtsOnder = new Point(172, 302);
        for (int i = 0; i < exec.getBins().size(); i++) {
            g2.draw(new Line2D.Float(bLinksBoven, bLinksOnder));
            g2.draw(new Line2D.Float(bLinksOnder, bRechtsOnder));
            g2.draw(new Line2D.Float(bRechtsOnder, bRechtsBoven));

            drawExpectedProducts(g2, i);

            int xLB = (int) bLinksBoven.getX() + 182;
            int xLO = (int) bLinksOnder.getX() + 182;
            int xRB = (int) bRechtsBoven.getX() + 182;
            int xRO = (int) bRechtsOnder.getX() + 182;
            bLinksBoven.setLocation(xLB, (int) bLinksBoven.getY());
            bLinksOnder.setLocation(xLO, (int) bLinksOnder.getY());
            bRechtsBoven.setLocation(xRB, (int) bRechtsBoven.getY());
            bRechtsOnder.setLocation(xRO, (int) bRechtsOnder.getY());

        }
    }

    private void drawExpectedProducts(Graphics2D g2, int i) {
        int productSize;
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(1));
        Bin currentBin = exec.getBins().get(i);
        int PX = (int) bLinksOnder.getX() + 2;
        int PY = (int) bLinksOnder.getY() - 32;
        for (Product p : currentBin.getProducts()) {
            productSize = p.getProduct_size();
            while (productSize > 0) {
                g2.fillRect(PX, PY, 160, 30);
                PY -= 30;
                productSize--;
            }
            g2.setColor(Color.WHITE);
            g2.drawString(Integer.toString(p.getProduct_size()), PX + 20, PY + 50);
            g2.draw(new Line2D.Float(PX, PY + 30, PX + 160, PY + 30));
            g2.setColor(Color.BLUE);
        }
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(6));
    }
}
