package Robot;

import java.util.ArrayList;

public class RobotStart {

    private ArrayList<Product> productsR = new ArrayList<>();
    //private ArrayList<Product> productsB = new ArrayList<>();
    private ArrayList<Product> TSPvolgorde = new ArrayList<>();
    private ArrayList<Product> BPPvolgorde = new ArrayList<>();
    private ArrayList<Bin> bins = new ArrayList<>();
    public Order orderFileZ, orderFileC;

    public RobotStart() {
        this.orderFileZ = XMLorderDOM.orderFile;
//        this.productsB = XMLorderDOM.orderFile.getProducts();
    }

    public void setOrder() {
        // XMLorderDOM.main();
        System.out.println("setorder details = " + XMLorderDOM.orderFile.getProducts());
        dbConnection.main();
        orderFileC = XMLorderDOM.orderFile;
    }

    public String stap1() {
        productsR = orderFileC.getProducts();
        return "Posities in magazijnstelling:\n" + orderFileC.printProductPositions();
    }

    public String stap2() {
        productsR = orderFileC.getProducts();
        return "Formaat van artikelen:\n" + orderFileC.printProductSizes();
    }

    public ArrayList<Product> setTSP(ArrayList<Product> products) {
        NearestNeighbor nn = new NearestNeighbor();
        TSPvolgorde = nn.solveTSP(products);
        System.out.println("De TSPvolgorde = " + TSPvolgorde);
        return TSPvolgorde;
    }

    public ArrayList<Bin> setBPP(ArrayList<Product> tspvolgorde) {
        bins = EigenAlgoritmeBPP.solveBPP(tspvolgorde);
        return bins;
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

    public ArrayList<Product> getProductsR() {
        return productsR;
    }

    public ArrayList<Product> getTSPvolgorde() {
        return TSPvolgorde;
    }

    public ArrayList<Product> getBPPvolgorde() {
        return BPPvolgorde;
    }

    public ArrayList<Bin> getBins() {
        return bins;
    }

    @Override
    public String toString() {
        return "RobotStart = " + productsR;
    }

}
