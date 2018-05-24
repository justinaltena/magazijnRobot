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
public class RobotControl {

    private String output = "";
    private ArrayList<Product> products = new ArrayList<>();
    String x = "";

    //Functie waar een ArrayList van bins ingaat en een string met getallen uitkomt
    //De functie zorgt ervoor dat afhankelijk van de positite van het product, elk product een int tussen de 1 en 15 krijgt die daarna wordt toegevoegd aan een string
    public String convertCoordinates(ArrayList<Bin> bins) {
        //De producten van alle bins worden toegevoegd aan een grote arraylist met alle producten
        for (Bin bin : bins) {
            products.addAll(bin.getProducts());
        }
        //Voor elk product wordt afhankelijk van de positie van dat product een waarde toegevoegd aan de string
        //Hieronder al deze waarden
        for (Product product : products) {
            if (product.getProductX() == 0 && product.getProductY() == 0) {
                x = "1,";
                output += x;
            } else if (product.getProductX() == 1 && product.getProductY() == 0) {
                x = "2,";
                output += x;
            } else if (product.getProductX() == 2 && product.getProductY() == 0) {
                x = "3,";
                output += x;
            } else if (product.getProductX() == 3 && product.getProductY() == 0) {
                x = "4,";
                output += x;
            } else if (product.getProductX() == 4 && product.getProductY() == 0) {
                x = "5,";
                output += x;
            } else if (product.getProductX() == 0 && product.getProductY() == 1) {
                x = "6,";
                output += x;
            } else if (product.getProductX() == 1 && product.getProductY() == 1) {
                x = "7,";
                output += x;
            } else if (product.getProductX() == 2 && product.getProductY() == 1) {
                x = "8,";
                output += x;
            } else if (product.getProductX() == 3 && product.getProductY() == 1) {
                x = "9,";
                output += x;
            } else if (product.getProductX() == 4 && product.getProductY() == 1) {
                x = "10,";
                output += x;
            } else if (product.getProductX() == 0 && product.getProductY() == 2) {
                x = "11,";
                output += x;
            } else if (product.getProductX() == 1 && product.getProductY() == 2) {
                x = "12,";
                output += x;
            } else if (product.getProductX() == 2 && product.getProductY() == 2) {
                x = "13,";
                output += x;
            } else if (product.getProductX() == 3 && product.getProductY() == 2) {
                x = "14,";
                output += x;
            } else if (product.getProductX() == 4 && product.getProductY() == 2) {
                x = "15,";
                output += x;
            }
        }
        return output;
    }
}
