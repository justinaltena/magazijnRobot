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
        if (bins.isEmpty()) {
            bins.add(new Bin(10));
            bins.add(new Bin(10));
        }
        for (Product currentProduct : this.products) {
            for (Bin currentBin : bins) {
                if (currentProduct.getProductSize() <= currentBin.getAvailableSize()) {
                    currentBin.addProduct(currentProduct);
                    packedProducts.add(currentProduct);
                    break;
                }
            }
            if (!packedProducts.contains(currentProduct)) {
                bins.add(new Bin(10));
                bins.add(new Bin(10));
                closedBins.add(bins.get(0));
                closedBins.add(bins.get(1));
                bins.remove(1);
                bins.remove(0);
                bins.get((bins.size() - 2)).addProduct(currentProduct);
                packedProducts.add(currentProduct);
            }
        }
        for (Bin binbin : bins) {
            if (binbin.getAvailableSize() != 10) {
                closedBins.add(binbin);
            }
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
