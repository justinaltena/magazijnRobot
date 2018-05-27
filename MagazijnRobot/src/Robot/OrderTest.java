package Robot;

import java.util.ArrayList;

public class OrderTest implements Runnable {

    public static ArrayList<Product> productsR = new ArrayList<>();
    public static ArrayList<Product> TSPvolgorde = new ArrayList<>();
    public static ArrayList<Product> BPPvolgorde = new ArrayList<>();
    public static ArrayList<Bin> bins = new ArrayList<>();
    public static Order orderFileZ, orderFileC;

    public static String stap1() {
        orderFileZ = XMLorderDOM.orderFile;
        dbConnection.main();
        orderFileC = XMLorderDOM.orderFile;
        return orderFileC.printProducts();
    }

    public static void stap2() {
        try {
            productsR = XMLorderDOM.orderFile.getProducts();
            System.out.print("gelukt products array aanmaken = ");
            System.out.println(productsR);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stap3() {
        TSPvolgorde = NearestNeighbor.solveTSP(productsR);
        System.out.println("De TSPvolgorde = " + TSPvolgorde);
    }

    @Override
    public void run() {

    }
}
