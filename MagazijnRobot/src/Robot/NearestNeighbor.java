/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Robot;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Justin Altena
 */
public class NearestNeighbor {

    public ArrayList<Product> solve(ArrayList<Product> products) {
        ArrayList<Product> route = new ArrayList<Product>() {
            {
                add(products.get(0));
            }
        };
        products.remove(0);

        while (true) {
            Product lastPoint = route.get(route.size() - 1);
            Product nearestProduct = getNearest(products, lastPoint);

            route.add(nearestProduct);
            products.remove(nearestProduct);

            if (products.size() <= 0) {
                break;
            }
        }

        return route;
    }

    private Product getNearest(ArrayList<Product> products, Product comparison) {
        double lowestDistance = -1;
        Product closestProduct = new Product(new Point());

        for (Product currentProduct : products) {
            double distance = currentProduct.getProductPosition().distance(comparison.getProductPosition());
            if (distance < lowestDistance || lowestDistance < 0) {
                closestProduct = currentProduct;
                lowestDistance = distance;
            }
        }
        return closestProduct;
    }

    public ArrayList<ArrayList<Product>> choppedProducts(ArrayList<Product> products) {
        ArrayList<Product> smallArray = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {

        }
    }
}
