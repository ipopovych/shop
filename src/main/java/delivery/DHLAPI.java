package delivery;

import articles.Order;

import java.util.Random;

public class DHLAPI {
    public String eineBestellungErstellen(Order order) {
        return String.valueOf(new Random().nextInt(1000000));
    }
    public boolean senden(String id) {
        return true;
    }
    public boolean verfugbarkeitPrufen(String id) {
        return true;
    }
}