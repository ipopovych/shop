package payment;

public class PaymentContext {
    private Payment payment;

    public PaymentContext(Payment payment){
        this.payment = payment;
    }

    public boolean process(double price){
        return payment.process(price);
    }
}
