package Robot;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RobotGUI extends JFrame implements ActionListener {

    private RobotStart rostart;
    private JButton jbLaadorder;
    private JButton start;

    private JLabel jlCustomer_id, jlOrder_id, jlOrder_date, jlProducten;

    private boolean orderCheck = false;

    public RobotGUI() {
        rostart = new RobotStart();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);

        setTitle("Controlesoftware AS/RS-opstelling");
        setPreferredSize(new Dimension(1500, 1000));
        setLayout(new FlowLayout());

//        OrderPanel orderpanel = new OrderPanel();
//        add(orderpanel);
        jbLaadorder = new JButton("Order inladen");
        add(jbLaadorder);
        jbLaadorder.addActionListener(this);
//        laadorder.setBounds(20, 20, 120, 60);
//        laadorder.addActionListener(this);
//
        start = new JButton("Start simulatie");
        add(start);
        // start.setBounds(20, 800, 120, 60);
        start.addActionListener(this);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbLaadorder) {
            if (orderCheck == true) {
                System.out.println("Er is al op geklikt");
            } else {
                XMLorderDOM.main();
                OrderPanel orderDetails = new OrderPanel();
                add(orderDetails);
                orderDetails.setVisible(true);
                orderCheck = true;
                pack();
            }
        } else if (e.getSource() == start) {
//            RobotStart.main();
        }

    }
}
