package articles;

import delivery.*;
import lombok.Getter;
import lombok.Setter;
import payment.CardPayment;
import payment.CashPayment;
import payment.PaymentContext;

import java.util.ArrayList;

public class Order {

    private ArrayList<Article> items;
    private DeliveryContext delivery;
    private PaymentContext payment;
    @Setter @Getter
    public double totalPrice = 0;


    public Order() {
        items = new ArrayList<>();
    }

    public Order(ArrayList<Article> items, String delivery, String payment) {
        setPayment(payment);
        setDelivery(delivery);
        setItems(items);
    }

    public boolean process(String deliveryAddress){
//        System.out.println(totalPrice);
        boolean status = payment.process(totalPrice);

        if(delivery != null) {
            status = status && delivery.process(this, deliveryAddress);
        }

        return status;
    }


    public double getPrice(ArrayList <Article> items) {
        double price = 0;
        for(Article item: items){
            price += item.getPrice();
        }
        return price;
    }

    public void addItem (Article item){
        items.add(item);
        totalPrice += item.getPrice();
    }

    public void setItems (ArrayList<Article> items){

        this.items = items;
        this.totalPrice = getPrice(items);
    }

    public void setDelivery (String delivery){
        switch (delivery) {
            case "UkrPoshta":
                this.delivery = new DeliveryContext(new UkrPoshtaWay());
                break;
            case "NovaPoshta":
                this.delivery = new DeliveryContext(new NovaPoshtaWay());
                break;
            case "DHL":
                this.delivery = new DeliveryContext(new DHLWay());
                break;
            default:
                this.delivery = null;
                break;
        }
    }


    public void setPayment (String payment){
        if (payment.equals("cash")){
            this.payment = new PaymentContext(new CashPayment());
        } else if (payment.equals("card")){
            this.payment = new PaymentContext(new CardPayment());
        } else {
            throw new IllegalArgumentException("Wrong payment argument passed");
        }
    }


    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("Your order: ");
        for (Article item: items){
            s.append("\n");
            s.append(item.toString());
        }
        return s.toString();
    }

}