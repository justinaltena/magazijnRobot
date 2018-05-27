package Robot;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class Pakbon extends JDialog {

    private Bin bin;
    private String name;
    private int nr;
    private JLabel jlPak;
    private static int x = 1200;
    private static int y = 250;

    public Pakbon(Bin b, String name, int i) {
        bin = b;
        this.name = name + " " + i;
        this.nr = i;

        setBounds(x, y, 300, 300);
        while (true) {
            x += 100;
            y += 100;
            break;
        }
        setLayout(null);
        setTitle(this.name);
        //setLocationRelativeTo(null);

        jlPak = new JLabel("<html>" + this.name + "<br>" + bin.printPakbon());
        add(jlPak);
        jlPak.setBounds(10, 10, 300, 200);

        //pack();
        setVisible(true);
    }
}
