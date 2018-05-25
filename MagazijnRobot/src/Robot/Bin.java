package Robot;

import java.util.ArrayList;

public class Bin {

    private int binSize;
    private ArrayList<Product> products;

    public Bin(int binSize) {
        this.binSize = binSize;
        products = new ArrayList<>();
    }

    //Methode om producten toe te voegen aan een bin
    public void addProduct(Product product) {
        //Wanneer er genoeg ruimte is in de bin om het product toe te voegen gebeurd dit, anders foutmelding
        if (product.getProduct_size() <= this.getAvailableSize()) {
            products.add(product);
        } else {
            System.out.println("Bin is full");
        }

    }

    //Methode om alle producten uit de bin te printen in de console
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

    //Methode om te kijken hoeveel ruimte er nog is in de bin
    public int getAvailableSize() {
        int size = 0;
        if (products.size() > 0) {
            for (Product product : products) {
                size += product.getProduct_size();
            }
            return this.binSize - size;
        } else {
            return this.binSize;
        }
    }

    @Override
    //Methode om de standaard printmethode aan te passen
    public String toString() {
        return "Bin{" + "binSize=" + binSize + " Free space:" + this.getAvailableSize() + ", products=" + products + '}';
    }
}
