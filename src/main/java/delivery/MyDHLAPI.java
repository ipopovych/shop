package delivery;


import articles.Order;

public class MyDHLAPI extends DHLAPI{
    public String createOrder(Order order){
     return eineBestellungErstellen(order);
    }
    public boolean send(String id) {
        return senden(id);
    }
    public boolean checkAvailability(String id) {
        return verfugbarkeitPrufen(id);
    }
}
