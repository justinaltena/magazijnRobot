package Robot;

import java.awt.Dimension;
import javax.swing.*;

public class OrderPanel extends JPanel {

    private JLabel jlCustomer_id, jlOrder_id, jlOrderdate, jlProducts;
    private JTextArea jtaCustomer_id, jtaOrder_id, jtaOrderdate, jtaProducts;

    public OrderPanel() {

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
}
