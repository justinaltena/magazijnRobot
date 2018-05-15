/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Robot;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Justin Altena
 */
public class Order {

    private int customer_id;
    private int order_id;
    private LocalDate order_date;
    private ArrayList<Product> products = new ArrayList<>();

    public Order(int customer_id, int order_id, LocalDate order_date, ArrayList<Product> products) {
        this.customer_id = customer_id;
        this.order_id = order_id;
        this.order_date = order_date;
        this.products = products;
    }
}