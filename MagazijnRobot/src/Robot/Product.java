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
        return "Product{" + "product_id=" + product_id + "productName=" + product_name
                + ", productSize=" + product_size + ", productPosition=" + product_position + '}';
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

}
