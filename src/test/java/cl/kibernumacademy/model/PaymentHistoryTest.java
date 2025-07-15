// Test unitario para la clase PaymentHistory
package cl.kibernumacademy.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentHistoryTest {
    @Test
    void testAddAndGetPayments() {
        // Crea un historial de pagos vacío
        PaymentHistory history = new PaymentHistory();
        // Crea un usuario de prueba
        User user = new User("Test User");
        // Crea un pago de prueba
        Payment payment = new Payment(100.0, user, "CreditCard", java.time.LocalDateTime.now());
        // Agrega el pago al historial
        history.add(payment);
        // Verifica que el historial tiene exactamente un pago
        assertEquals(1, history.getPayments().size());
        // Verifica que el pago agregado es el mismo que se recupera
        assertEquals(payment, history.getPayments().get(0));
    }
}
