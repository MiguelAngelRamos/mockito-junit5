// Test unitario para la clase User
package cl.kibernumacademy.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void testUserCreation() {
        // Crea un usuario con el nombre "Test User"
        User user = new User("Test User");
        // Verifica que el nombre del usuario es el esperado
        assertEquals("Test User", user.getName());
    }
}
