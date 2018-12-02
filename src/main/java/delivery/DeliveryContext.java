package delivery;

import articles.Order;

public class DeliveryContext {
    private DeliveryWay delivery;

    public DeliveryContext(DeliveryWay delivery){
        this.delivery = delivery;
    }

    public boolean process(Order order, String address) {
        return delivery.process(order, address);
    }
}

