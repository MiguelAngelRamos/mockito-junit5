package cl.kibernumacademy.service;

import cl.kibernumacademy.model.User;

// Interfaz que representa un método de pago genérico
// Esta interfaz es clave para la inyección de dependencias y el uso de mocks en los tests
// En los tests, se crean mocks de PaymentMethod para simular distintos comportamientos
public interface PaymentMethod {
    // Método para procesar un pago. En los tests, el mock de este método es configurado con given(...).willReturn(...)
    boolean process(double amount, User user);
    // Devuelve el nombre del método de pago (por ejemplo, "CreditCard" o "BankTransfer")
    String getMethodName();
}
