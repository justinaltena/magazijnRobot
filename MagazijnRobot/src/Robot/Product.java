
package Robot;

import java.awt.Point;


public class Product {
    
    private int product_id;
    private String product_name;
    private int product_size;
    private Point product_position;

    public Product(String productName, int productSize, Point productPosition) {
        this.product_name = productName;
        this.product_size = productSize;
        this.product_position = productPosition;

    }

    public Product(Point productPosition) {
        this.productPosition = productPosition;
    }

    @Override
    public String toString() {
        return "Product{" + "productName=" + product_name + ", productSize=" + product_size + ", productPosition=" + product_position + '}';
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
