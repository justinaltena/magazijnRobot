/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Robot;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Justin Altena
 */
public class EigenAlgoritmeBPP {

    private static ArrayList<Bin> bins = new ArrayList<>();
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Product> packedProducts = new ArrayList<>();
    private static ArrayList<Bin> closedBins = new ArrayList<>();

    public static ArrayList<Bin> solveBPP(ArrayList<Product> products) {
        EigenAlgoritmeBPP.products = products;
        ArrayList<ArrayList<Product>> choppedProducts = chopped(EigenAlgoritmeBPP.products);
        ArrayList<Product> reversedProducts = reverseProducts(choppedProducts);
        if (bins.isEmpty()) {
            bins.add(new Bin(10));
            bins.add(new Bin(10));
        }
        for (Product currentProduct : reversedProducts) {
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

    private static ArrayList<ArrayList<Product>> chopped(ArrayList<Product> products) {
        ArrayList<ArrayList<Product>> choppedArrayList = new ArrayList<>();
        int N = products.size();
        for (int i = 0; i < N; i += 3) {
            choppedArrayList.add(new ArrayList<Product>(products.subList(i, Math.min(N, i + 3))));
        }
        return choppedArrayList;
    }

    private static ArrayList<Product> reverseProducts(ArrayList<ArrayList<Product>> choppedProducts) {
        ArrayList<Product> reversedProducts = new ArrayList<>();
        for (ArrayList<Product> part : choppedProducts) {
            Collections.reverse(part);
            for (Product product : part) {
                reversedProducts.add(product);
            }
        }
        return reversedProducts;
    }
}
