package cl.kibernumacademy.model;

public class Payment {
    private final double amount;
    private final User user;
    private final String method;
    private final java.time.LocalDateTime date;

    public Payment(double amount, User user, String method, java.time.LocalDateTime date) {
        this.amount = amount;
        this.user = user;
        this.method = method;
        this.date = date;
    }

    public double getAmount() { return amount; }
    public User getUser() { return user; }
    public String getMethod() { return method; }
    public java.time.LocalDateTime getDate() { return date; }
}
