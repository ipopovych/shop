package delivery;

import articles.Order;
import config.Confing;

public class DHLWay implements DeliveryWay{
    @Override
    public boolean process(Order order, String address){
        String id = Confing.dhlapi.createOrder(order);
        Confing.dhlapi.send(id);
        System.out.println("Processing delivery to address: " + address);
        return true;
    }
}
