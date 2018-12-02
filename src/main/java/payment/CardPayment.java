package payment;

public class CardPayment implements Payment {
    @Override
    public boolean process(double price) {
        System.out.println("Paying with credit card...\nYou paid " + price);
        return true;
    }
}
