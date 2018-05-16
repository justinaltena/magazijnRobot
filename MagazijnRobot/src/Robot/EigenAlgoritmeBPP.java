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
public class EigenAlgoritmeBPP {

    private ArrayList<Bin> bins = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Product> packedProducts = new ArrayList<>();
    private ArrayList<Bin> closedBins = new ArrayList<>();

    public ArrayList<Bin> solve(ArrayList<Product> products) {
        this.products = products;
        bins.add(new Bin(10));
        bins.add(new Bin(10));
        for (Product currentProduct : products) {
            if (currentProduct.getProductSize() <= bins.get(0).getAvailableSize()) {
                bins.get(0).addProduct(currentProduct);
                packedProducts.add(currentProduct);
            } else if (currentProduct.getProductSize() <= bins.get(0).getAvailableSize()) {
                bins.get(1).addProduct(currentProduct);
                packedProducts.add(currentProduct);
            }
            System.out.println(bins);
        }
        for (Bin currentBin : bins) {
            closedBins.add(currentBin);
            bins.remove(currentBin);
        }
        return closedBins;
    }

    public ArrayList<Bin> getBins() {
        return bins;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
