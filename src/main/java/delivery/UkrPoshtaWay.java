package delivery;

import articles.Order;

public class UkrPoshtaWay implements DeliveryWay{
    @Override
    public boolean process(Order order, String address) {
        System.out.println("Processing delivery to address: " + address);
        return true;
    }
}
