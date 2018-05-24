package Robot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.JFrame.setDefaultLookAndFeelDecorated;
import javax.swing.border.EmptyBorder;

public class OrderPanel extends JPanel {

    private JLabel jlCustomer_id, jlOrder_id, jlOrderdate, jlProducts;
    private JLabel jtaCustomer_id, jtaOrder_id, jtaOrderdate, jtaProducts;

    public OrderPanel() {

        setSize(new Dimension(10, 100));
        //setAlignmentX(LEFT_ALIGNMENT);
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setLayout(new GridLayout(4, 2));
        //setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
        setDefaultLookAndFeelDecorated(true);

        jlCustomer_id = new JLabel("Klantnummer:");
        try {
            add(jlCustomer_id);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        // add(Box.createRigidArea(new Dimension(0, 50)));
        //add(Box.createVerticalGlue());

        //add(Box.createRigidArea(new Dimension(0, 5)));
        jtaCustomer_id = new JLabel(String.valueOf(XMLorderDOM.orderFile.getCustomer_id()));
        add(jtaCustomer_id);
        // setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jlOrder_id = new JLabel("Order ID:");
        try {
            add(jlOrder_id);
        } catch (Exception e2) {
            e2.printStackTrace();
        }

        jtaOrder_id = new JLabel(String.valueOf(XMLorderDOM.orderFile.getOrder_id()));
        //jtaOrder_id.setText();
        add(jtaOrder_id);

        jlOrderdate = new JLabel("Orderdatum:");
        add(jlOrderdate);

        jtaOrderdate = new JLabel(String.valueOf(XMLorderDOM.orderFile.getOrder_date()));
        add(jtaOrderdate);

        jlProducts = new JLabel("Producten:");
        add(jlProducts);

        //jtaProducts = new JLabel("<html>Ik kom hier voor mij lol<br/>Begrepen?</html>", SwingConstants.CENTER);
        jtaProducts = new JLabel(String.valueOf(XMLorderDOM.orderFile.printProducts()));
        add(jtaProducts);
        revalidate();
    }

}
