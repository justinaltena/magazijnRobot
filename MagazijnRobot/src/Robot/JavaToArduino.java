/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Robot;

import com.fazecast.jSerialComm.SerialPort;
import java.awt.Point;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 *
 * @author Justin Altena
 */
public class JavaToArduino {

    static SerialPort arduino;

    public static void controlTSP(ArrayList<Product> tspvolgorde) {

    }

    public static void controlBPP(ArrayList<Bin> bins) {

    }

    public static void main(String[] args) {
        //testwaarden
        Point point1 = new Point(0, 2);
        Point point2 = new Point(4, 1);
        Point point3 = new Point(3, 0);
        Point point4 = new Point(2, 1);
        Point point5 = new Point(0, 1);
        Point point6 = new Point(2, 2);
        Point point7 = new Point(0, 0);

        ArrayList<Product> products = new ArrayList<>();

        Product p1 = new Product(1, "test", 4, point1);
        Product p2 = new Product(2, "test2", 2, point2);
        Product p3 = new Product(3, "test2", 3, point3);
        Product p4 = new Product(4, "test2", 1, point4);
        Product p5 = new Product(5, "test2", 5, point5);
        Product p6 = new Product(6, "test3", 6, point6);
        Product p7 = new Product(7, "test4", 3, point7);

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p6);
        products.add(p7);

//        Bin bin1 = new Bin(5);
//        System.out.println(bin1.getAvailableSize());
//        bin1.addProduct(p1);
//        System.out.println(bin1.getAvailableSize());
//        bin1.addProduct(p2);
//        bin1.printBin();
//        System.out.println(bin1.getAvailableSize());
//        double distance = point1.distance(point2);
//        System.out.println("The distance between the points is " + distance);
//        ArrayList<Product> sortedProducts = NearestNeighbor.solveTSP(products);
////       System.out.println(sortedProducts);
//        ArrayList<Bin> packedBins = EigenAlgoritmeBPP.solveBPP(sortedProducts);
////        System.out.println(packedBins.size());
////        System.out.println(packedBins);
//
//        String stringForArduino = new RobotControl().convertCoordinates(packedBins);
////        System.out.println(stringForArduino);
        String comport = "com5";//Waarde van de poort invullen waar arduino op aangesloten wordt
        arduino = SerialPort.getCommPort(comport);
        arduino.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        //Als de poort geopend kan worden wordt deze code uitgevoerd, anders wordt een foutmelding gegeven
        if (arduino.openPort() == true) {
            //Open een nieuwe Thread waarop dit proces kan runnen
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        //Er wordt een nieuwe outputStream geopend op de seriele poort van de arduino
                        OutputStream a = arduino.getOutputStream();
                        //System.out.println(stringForArduino);
                        //De String met voorbeeld getallen wordt hier in bytes gestuurd naar de arduino waar ze verder afgehandeld worden
                        //a.write(stringForArduino.getBytes());
                        //Na het verzenden van het bericht wordt de outputstream schoongemaakt en de outputstream gesloten
                        a.flush();
                        a.close();
                        //Als er een fout optreedt in het proces wordt die hier opgevangen
                    } catch (IOException e) {
                        System.out.println("Error");
                    }
                    //Na het sluiten van de outputstream kan ook de verbinding worden verbroken
                    arduino.closePort();
                    System.out.println("CLOSE COM");
                }
            };
            thread.start();
        } else {
            System.out.println("Cannot open port: " + comport);
        }
    }
}
