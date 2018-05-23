package Robot;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class TSPPanel extends JPanel {

    public TSPPanel() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
    }

    public void drawRoute(Graphics g, ArrayList<Product> products) {
        g.drawLine(0, 0, products.get(0).getProductX(), products.get(0).getProductY());
        Product previousProduct = products.get(0);
        for (Product product : products) {
            g.drawLine(previousProduct.getProductX(), previousProduct.getProductY(), product.getProductX(), product.getProductY());
            previousProduct = product;
        }

    }
}
