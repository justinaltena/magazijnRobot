package Robot;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RobotGUI extends JFrame {

    private RobotStart rostart;
    private JButton jbVk;
    private JButton jbAn;

    private JLabel jlAantalPlaatsen;
    private JLabel jlAantalVerkocht;

    private JTextField jtAantalVerkopen;
    private JTextField jtAantalAnnuleren;

    public RobotGUI() {
        rostart = new RobotStart();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Controlesoftware AS/RS-opstelling");
        pack();
        setLayout(new GridLayout(3, 3));

        add(new JLabel("aantal plaatsen vrij:"));
        //String aantalPlaatsen = String.valueOf(voorstelling.getAantalPlaatsen());
        //jlAantalPlaatsen = new JLabel(aantalPlaatsen);
        add(jlAantalPlaatsen);

        add(new JLabel("aantal verkocht:"));
        //String aantalVerkocht = String.valueOf(voorstelling.getAantalVerkocht());
        //jlAantalVerkocht = new JLabel(aantalVerkocht);
        add(jlAantalVerkocht);

        jbVk = new JButton("Verkoop kaartje");
        add(jbVk);
        //jbVk.addActionListener(this);
        jbAn = new JButton("Annuleer verkoop");
        add(jbAn);
        //jbAn.addActionListener(this);

        setVisible(true);
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == jbVk) {
//            voorstelling.verkoopKaartje();
//        } else if (e.getSource() == jbAn) {
//            voorstelling.annuleerKaartje();
//        }
//
//        jlAantalPlaatsen.setText(String.valueOf(voorstelling.getAantalPlaatsen()));
//        jlAantalVerkocht.setText(String.valueOf(voorstelling.getAantalVerkocht()));
//    }
}
