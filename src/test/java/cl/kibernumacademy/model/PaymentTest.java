// Test unitario para la clase Payment
package cl.kibernumacademy.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    @Test
    void testPaymentCreation() {
        // Crea un usuario de prueba
        User user = new User("Test User");
        // Crea un pago de prueba con monto, usuario, método y fecha
        Payment payment = new Payment(100.0, user, "CreditCard", java.time.LocalDateTime.now());
        // Verifica que el monto es el esperado
        assertEquals(100.0, payment.getAmount());
        // Verifica que el usuario es el esperado
        assertEquals(user, payment.getUser());
        // Verifica que el método de pago es el esperado
        assertEquals("CreditCard", payment.getMethod());
        // Verifica que la fecha no es nula
        assertNotNull(payment.getDate());
    }
}
