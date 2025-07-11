package cl.kibernumacademy.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PaymentHistory {
    private final List<Payment> payments = new ArrayList<>();

    public void add(Payment payment) {
        payments.add(payment);
    }

    public List<Payment> getPayments() {
        return Collections.unmodifiableList(payments);
    }
}
