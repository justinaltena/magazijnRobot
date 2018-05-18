/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Robot;

import java.util.ArrayList;

/**
 *
 * @author Justin Altena
 */
public class Bin {

    private int binSize;
    private ArrayList<Product> products;

    public Bin(int binSize) {
        this.binSize = binSize;
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product.getProductSize() <= this.getAvailableSize()) {
            products.add(product);
        } else {
            System.out.println("Bin is full");
        }

    }

    public void printBin() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public int getBinSize() {
        return this.binSize;
    }

    public int getAvailableSize() {
        int size = 0;
        if (products.size() > 0) {
            for (Product product : products) {
                size += product.getProductSize();
            }
            return this.binSize - size;
        } else {
            return this.binSize;
        }
    }

    @Override
    public String toString() {
        return "Bin{" + "binSize=" + binSize + " Free space:" + this.getAvailableSize() + ", products=" + products + '}';
    }

    public double getFilledPercentage() {
        double totalSize = 0;
        for (Product product : products) {
            totalSize = totalSize + product.getProductSize();
        }
        return totalSize;
    }
}
