package discounts;

import articles.Order;

public class Discount20 extends Discount {
    public Discount20 (Order order) {
        super(order);
        super.setPrice(super.getPrice() * 0.8);
    }

    public boolean process(String deliveryAddress) {
        return super.process(deliveryAddress);
    }
}

