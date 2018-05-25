package Robot;

import java.util.ArrayList;

public class RobotStart {

    public static ArrayList<Product> products = new ArrayList<>();
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
            products = XMLorderDOM.orderFile.getProducts();
            System.out.println("gelukt products array aanmaken");
            System.out.println(products);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stap3() {
        TSPvolgorde = NearestNeighbor.solveTSP(products);

    }

    public static void main() {

        //RobotPRGUI.RFrame.addText(orderFileC.printProducts());
        /*
        1 XMLdatabaseDOM
                input = product_id
                output = coördinaten & size

        1a COÖRDINATEN TEKENEN

        2 Nearest Neighbor -> solve()
                input = ArrayList<Product> uit order
                output = ArrayList<Product> in TSPvolgorde
            TSPvolgorde = NearestNeighbor.solve(products);

        2a ROUTE TEKENEN

        3 EigenAlgoritme -> solve()
                input = ArrayList<Product> in TSPvolgorde
                output = ArrayList<bins> in BPPvolgorde
            bins = EigenAlgoritme.solve()

        3a VERWACHTE OPVULLING BINS TEKENEN

        4-1 RobotAansturing TSP
                input = ArrayList<Product> in TSPvolgorde
                output = Locatie updates van ophaalrobot (Point)
                beginmethode = ArrayList<Product> omtoveren naar int 1,6,8 (bv)
                x = 0,1,2,3,4
                y = 0*5,1*5,2*5,3*5

        4-2 RobotAansturing BPP
                input = ArrayList<Bin> bins
                output = ...

        5 Pakbon maken per bin
                input = ArrayList<Bin> bins
                output = dialoog per pakbon (optioneel: pdf)
         */
    }

}
