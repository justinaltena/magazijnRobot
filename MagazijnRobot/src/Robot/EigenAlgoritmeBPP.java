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

    //Methode waar een ArrayList met producten ingaat,de producten inpakt, en daarna een ArrayList met bins terugstuurd
    public static ArrayList<Bin> solveBPP(ArrayList<Product> products) {
        EigenAlgoritmeBPP.products.addAll(products);
        //De inkomende ArrayList met producten wordt eerst in stukjes van 3 gehakt en daarna worden al die stukjes omgedraaid. Bij de functie meer info
        ArrayList<ArrayList<Product>> choppedProducts = chopped(EigenAlgoritmeBPP.products);
        ArrayList<Product> reversedProducts = reverseProducts(choppedProducts);
        //Als er nog geen bins zijn worden er twee nieuwe lege bins aangemaakt
        if (bins.isEmpty()) {
            bins.add(new Bin(10));
            bins.add(new Bin(10));
        }
        //Voor elk product in de lijst met omgedraaide producten wordt gekeken of ze in één van de bestaande bins passen
        //Als ze niet in de eerste passen wordt er in de andere geopende bins gekeken. Als ze in een bin geplaatst worden, wordt het product ook in de arraylist packedproducts geplaatst
        //Hierin staan alle producten die ingepakt zijn
        for (Product currentProduct : reversedProducts) {
            for (Bin currentBin : bins) {
                if (currentProduct.getProduct_size() <= currentBin.getAvailableSize()) {
                    currentBin.addProduct(currentProduct);
                    packedProducts.add(currentProduct);
                    break;
                }
            }
            //Als een product niet in een van de bins past(en dus ook niet is toegevoegd aan packedproducts) worden er twee nieuwe bins geopend
            //De oude twee bins worden toegevoegd aan een arraylist met closedbins. Daarin staan alle bins die afgesloten zijn
            //Ook worden de twee net gesloten bins verwijderd uit de oude arrayList met bins
            //Het product dat op dat moment bekeken werd wordt dan toegevoegd aan de eerste nieuw toegevoegde bin
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
        //Nadat alle bins bekeken zijn worden alle bins die niet leeg zijn en ook nog niet zijn toegevoegd aan closedbins toegevoegd aan closedbins
        for (Bin binbin : bins) {
            if (binbin.getAvailableSize() != 10) {
                closedBins.add(binbin);
            }
        }
        //De arrayList met closedbins wordt teruggegeven als resultaat van de methode
        return closedBins;
    }

    //De methode chopped zorgt ervoor dat de ArrayList die uit het tsp algoritme komt in stukjes van 3 wordt gehakt zodat de robot weet welke producten die moet pakken
    private static ArrayList<ArrayList<Product>> chopped(ArrayList<Product> products) {
        //Er wordt een nieuwe arraylist gemaakt van ArrayList met producten daarin
        ArrayList<ArrayList<Product>> choppedArrayList = new ArrayList<>();
        int N = products.size();
        //In die arraylist worden alle opgehakte stukjes van de oude arraylist geplaatst. Hiervoor wordt de methode sublist gebruikt
        //Die zorgt ervoor dat een arraylist gesplit wordt van het eerste element dat gesplit moet worden tot en met het laatste element dat in dat stukje moet komen
        for (int i = 0; i < N; i += 3) {
            choppedArrayList.add(new ArrayList<Product>(products.subList(i, Math.min(N, i + 3))));
        }
        return choppedArrayList;
    }

    //De functie reverseProduct zorgt ervoor dat de opgehakte stukjes uit de vorige methode omgedraaid worden en daarna weer in 1 arraylist gezet worden
    //Op deze manier wordt ervoor gezorgd dat de pakketjes in de goede volgorde bij de bpp robot aankomen
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
