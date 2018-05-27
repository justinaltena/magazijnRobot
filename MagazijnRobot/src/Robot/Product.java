package Robot;

import java.awt.Point;

public class Product {

    private int product_id;
    private String product_name;
    private int product_size;
    private Point product_position;
    public boolean checked;

    public Product(int product_id, String productName, int productSize, Point productPosition) {
        this.product_id = product_id;
        this.product_name = productName;
        this.product_size = productSize;
        this.product_position = productPosition;
        this.checked = false;
    }

    public Product(int product_id, String product_name) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.checked = false;
    }

    public Product(Point productPosition) {
        this.product_position = productPosition;
        this.checked = false;
    }

    @Override
    public String toString() {
        return "product_id=" + product_id + " product_name=" + product_name + " product_position=" + product_position + " product_size=" + product_size;
    }

    public String printCoordinates() {
        return "x = " + getProductX() + "  y = " + getProductY();
    }

    public String printSize() {
        return Integer.toString(product_size);
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public int getProduct_size() {
        return product_size;
    }

    public Point getProduct_position() {
        return product_position;
    }

    public int getProductX() {
        return (int) product_position.getX();
    }

    public int getProductY() {
        return (int) product_position.getY();
    }

    public void setProduct_size(int product_size) {
        this.product_size = product_size;
    }

    public void setProduct_position(Point product_position) {
        this.product_position = product_position;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

}
