package Robot;

import java.awt.Point;

public class Product {

    private int product_id;
    private String product_name;
    private int product_size;
    private Point product_position;

    public Product(int product_id, String productName, int productSize, Point productPosition) {
        this.product_id = product_id;
        this.product_name = productName;
        this.product_size = productSize;
        this.product_position = productPosition;

    }

    public Product(int product_id, String product_name) {
        this.product_id = product_id;
        this.product_name = product_name;
    }

    public Product(Point productPosition) {
        this.product_position = productPosition;
    }

    @Override
    public String toString() {
        return "product_id=" + product_id + " " + getProductX() + " " + getProductY();
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getProductName() {
        return product_name;
    }

    public int getProductSize() {
        return product_size;
    }

    public Point getProductPosition() {
        return product_position;
    }

    public int getProductX() {
        return (int) product_position.getX();
    }

    public int getProductY() {
        return (int) product_position.getY();
    }
}
