package Robot;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.*;

public class TSPPanel extends JPanel {

    private JLabel jlCustomer_id, jlOrder_id, jlOrderdate, jlProducts;
    private JTextArea jtaCustomer_id, jtaOrder_id, jtaOrderdate, jtaProducts;

    public TSPPanel() {

        setPreferredSize(new Dimension(250, 80));
        setAlignmentX(LEFT_ALIGNMENT);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        jlCustomer_id = new JLabel("Klantnummer:");
        add(jlCustomer_id);

        add(Box.createRigidArea(new Dimension(0, 5)));
        jtaCustomer_id = new JTextArea();
        add(jtaCustomer_id);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        setVisible(true);

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
