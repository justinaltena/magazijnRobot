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
public class Product {

    private String productName;
    private int productSize;
    private Point productPosition;

    public Product(String productName, int productSize, Point productPosition) {
        this.productName = productName;
        this.productSize = productSize;
        this.productPosition = productPosition;

    }

    @Override
    public String toString() {
        return "Product{" + "productName=" + productName + ", productSize=" + productSize + ", productPosition=" + productPosition + '}';
    }

    public String getProductName() {
        return productName;
    }

    public int getProductSize() {
        return productSize;
    }

    public Point getProductPosition() {
        return productPosition;
    }

}
