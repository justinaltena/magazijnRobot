package Robot;

import java.awt.Point;
import java.util.ArrayList;

public class NearestNeighbor {

    //Methode waar een ArrayList met producten ingaat,de producten op de goede volgorde, en daarna een ArrayList met die producten terugstuurd
    public static ArrayList<Product> solveTSP(ArrayList<Product> products) {
        //Er wordt een nieuwe arraylist met producten aangemaakt waaraan het eerste product van de ingekomen arraylist wordt toegevoegd
        ArrayList<Product> route = new ArrayList<Product>() {
            {
                add(products.get(0));
            }
        };
        //Dat product wordt weer uit de oude arraylist gehaald
        products.remove(0);

        //Zo lang de ingekomen lijst met producten niet leeg is wordt de code in deze while loop uitgevoerd
        while (true) {
            //Er wordt een variabele lastPoint aangemaakt die dezelfde waarde krijgt als het laatst toegevoegde product van route
            Product lastPoint = route.get(route.size() - 1);
            //Daarna wordt er weer een nieuw product aangemaakt die de waarde krijgt van het dichtsbijzijnde punt van het laatst toegevoegde punt aan de route
            Product nearestProduct = getNearest(products, lastPoint);
            //Dat product wordt dan weer toegevoegd aan de route en verwijderd uit de oude array met producten
            route.add(nearestProduct);
            products.remove(nearestProduct);

            //Als er geen producten meer in de oude array zitten wordt de while loop beeindigd
            if (products.size() <= 0) {
                break;
            }
        }

        return route;
    }

    //Methode die het dichtsbijzijndste product weergeeft uit een arraylist met producten vergeleken met een meegegeven product
    private static Product getNearest(ArrayList<Product> products, Product comparison) {
        //Er wordt een double aangemaakt die de afstand tussen de producten bijhoudt, met startwaarde -1
        double lowestDistance = -1;
        Product closestProduct = new Product(new Point());
        //Voor alle producten uit de meegegeven arraylist wordt de afstand berekent tussen het huidige product en het vergelijkingsproduct
        for (Product currentProduct : products) {
            double distance = currentProduct.getProduct_position().distance(comparison.getProduct_position());
            //Als die afstand kleiner is als de kleinste afstand tot nu toe, of kleiner is als 0(wat aangeeft dat het het eerste product is)
            //Krijgt closestProduct de waarde van het huidige product en wordt de kleinste afstand aangepast aan deze kortste afstand
            if (distance < lowestDistance || lowestDistance < 0) {
                closestProduct = currentProduct;
                lowestDistance = distance;
            }
        }
        //Het dichtsbijzijndste product wordt teruggestuurd
        return closestProduct;
    }

}
