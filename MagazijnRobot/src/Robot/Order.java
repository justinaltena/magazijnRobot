package Robot;

import java.time.LocalDate;
import java.util.ArrayList;

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

    @Override
    public String toString() {
        return "Order{" + "customer_id=" + customer_id + ", order_id=" + order_id + ", order_date=" + order_date + ", products=" + products + '}';
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public LocalDate getOrder_date() {
        return order_date;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

}
