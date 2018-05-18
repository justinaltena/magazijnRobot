package Robot;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RobotGUI extends JFrame implements ActionListener {

    private RobotStart rostart;
    private JButton laadorder;
    private JButton start;

    private JLabel jlCustomer_id, jlOrder_id, jlOrder_date, jlProducten;

    private JTextField jtAantalVerkopen;
    private JTextField jtAantalAnnuleren;

    public RobotGUI() {
        rostart = new RobotStart();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Controlesoftware AS/RS-opstelling");
        this.setSize(new Dimension(1500, 1000));
        setLayout(new FlowLayout());

        laadorder = new JButton("Order inladen");
        add(laadorder);
        laadorder.setBounds(20, 20, 120, 60);
        laadorder.addActionListener(this);

        jlCustomer_id = new JLabel("Klantnummer:");
        add(jlCustomer_id);

//
//        add(new JLabel("aantal verkocht:"));
//        //String aantalVerkocht = String.valueOf(voorstelling.getAantalVerkocht());
//        //jlAantalVerkocht = new JLabel(aantalVerkocht);
//        add(jlAantalVerkocht);
        start = new JButton("Start simulatie");
        add(start);
        start.setBounds(20, 800, 120, 60);
        start.addActionListener(this);

        // this.pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == laadorder) {
            XMLorderDOM.main();
            OrderPanel orderDetails = new OrderPanel();
            orderDetails.setVisible(true);
        }// else if (e.getSource() == jbAn) {
//            voorstelling.annuleerKaartje();
//        }

    }
}
