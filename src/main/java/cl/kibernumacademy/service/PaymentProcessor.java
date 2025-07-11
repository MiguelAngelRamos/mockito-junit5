// Clase principal que orquesta el procesamiento de pagos
// En los tests, sus dependencias (PaymentMethod y PaymentHistory) son reemplazadas por mocks
// Así se puede probar la lógica de PaymentProcessor de forma aislada
package cl.kibernumacademy.service;

import cl.kibernumacademy.model.Payment;
import cl.kibernumacademy.model.PaymentHistory;
import cl.kibernumacademy.model.User;
import java.time.LocalDateTime;

public class PaymentProcessor {
    private final PaymentMethod creditCardPayment;
    private final PaymentMethod bankTransferPayment;
    private final PaymentHistory paymentHistory;

    public PaymentProcessor(PaymentMethod creditCardPayment, PaymentMethod bankTransferPayment, PaymentHistory paymentHistory) {
        this.creditCardPayment = creditCardPayment;
        this.bankTransferPayment = bankTransferPayment;
        this.paymentHistory = paymentHistory;
    }

    public boolean processPayment(double amount, User user, String method) {
        // Este método es el que se prueba en los tests unitarios.
        // Los tests llaman a processPayment y, según el método de pago recibido,
        // este método delega la operación al método process del mock correspondiente.
        // Por ejemplo, si method es "CreditCard", se llama a creditCardPayment.process(...)
        // y el valor retornado depende de la configuración del mock en el test (given...willReturn...).
        if (amount <= 0 || user == null) {
            throw new IllegalArgumentException("Invalid amount or user");
        }
        boolean result;
        if ("CreditCard".equalsIgnoreCase(method)) {
            result = creditCardPayment.process(amount, user); // Aquí se invoca el mock en los tests
        } else if ("BankTransfer".equalsIgnoreCase(method)) {
            result = bankTransferPayment.process(amount, user);
        } else {
            throw new IllegalArgumentException("Unknown payment method");
        }
        if (result) {
            paymentHistory.add(new Payment(amount, user, method, LocalDateTime.now()));
        }
        return result;
    }

    public PaymentHistory getPaymentHistory() {
        return paymentHistory;
    }
}
