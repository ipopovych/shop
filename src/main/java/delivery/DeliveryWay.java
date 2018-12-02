package delivery;

import articles.Order;

public interface DeliveryWay {
    boolean process (Order order, String address);
}
