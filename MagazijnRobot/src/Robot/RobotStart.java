/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Robot;

import java.awt.Point;

/**
 *
 * @author Justin Altena
 */
public class RobotStart {

    public static void main(String[] args) {
        //RobotGUI gui = new RobotGUI();
        //gui.setVisible(true);

        Point point1 = new Point(3, 1);
        Product p1 = new Product("test", 1, point1);
        Product p2 = new Product("test2", 1, point1);
        Bin bin1 = new Bin(5);
        bin1.addProduct(p1);
        bin1.addProduct(p2);
        bin1.printBin();

    }
}
