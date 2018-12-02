package discounts;

import articles.Order;

public class Discount extends Order {
    private Order order;

    public Order getOrder() {
        return order;
    }

    public Discount(){}
    public Discount(Order order) { this.order = order;}

    public boolean process(String deliveryAddress) {
        return order.process(deliveryAddress);
    }
    public double getPrice() {
        return order.getTotalPrice();
    }
    public void setPrice(double price) {
        order.setTotalPrice(price);
    }


}