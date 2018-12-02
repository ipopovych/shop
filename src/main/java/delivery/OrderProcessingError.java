package delivery;

public class OrderProcessingError extends Exception {
    public OrderProcessingError() { super(); }
    public OrderProcessingError(String message) { super(message); }
    public OrderProcessingError(String message, Throwable cause) { super(message, cause); }
    public OrderProcessingError(Throwable cause) { super(cause); }
}
