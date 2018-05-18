package Robot;

import java.awt.Point;
import java.util.ArrayList;

public class RobotSchermStart {

    public static void main(String[] args) {
        //RobotGUI gui = new RobotGUI();

        Point point1 = new Point(3, 1);
        Point point2 = new Point(9, 4);
        Point point3 = new Point(2, 7);
        Point point4 = new Point(1, 4);
        Point point5 = new Point(5, 5);

        ArrayList<Product> products = new ArrayList<>();

        Product p1 = new Product(0, "test", 4, point1);
        Product p2 = new Product(1, "test2", 2, point2);
        Product p3 = new Product(2, "test2", 3, point3);
        Product p4 = new Product(3, "test2", 1, point4);
        Product p5 = new Product(4, "test2", 5, point5);
        Product p6 = new Product(5, "test3", 6, point5);
        Product p7 = new Product(6, "test4", 3, point5);

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
//        System.out.println(new NearestNeighbor().solve(products));
        System.out.println(new EigenAlgoritmeBPP().solve(products));
    }
}
