package payment;

public class CashPayment implements Payment {
    @Override
    public boolean process(double price) {
        System.out.println("Paying with cash...\nYou paid " + price);
        return true;
    }
}
