// Implementación concreta de PaymentMethod para pagos con tarjeta de crédito
// En los tests, esta clase es reemplazada por un mock para simular distintos escenarios
package cl.kibernumacademy.service;

import cl.kibernumacademy.model.User;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public boolean process(double amount, User user) {
        // Aquí iría la lógica real de procesamiento con tarjeta
        // En los tests, este método es simulado por el mock
        return true;
    }

    @Override
    public String getMethodName() {
        return "CreditCard";
    }
}
