package cl.kibernumacademy.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
// Mockito
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.verify;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.kibernumacademy.model.Payment;
import cl.kibernumacademy.model.PaymentHistory;
import cl.kibernumacademy.model.User;

@ExtendWith(MockitoExtension.class) // habilita la extension para trabajar con mockito y junit
public class PaymentProcessorTest {

  @Mock
  private PaymentMethod creditCardPayment;

  @Mock
  private PaymentMethod bankTransferPayment;

  @Mock
  private PaymentHistory paymentHistory;

  @Captor // Permite capturar argumentos pasados a métodos mockeados
  private ArgumentCaptor<Payment> paymentCaptor;

  @InjectMocks // Inyecta los mocks en la instancia real PaymentProcessor
  private PaymentProcessor paymentProcessor;

  private User user;


  @BeforeEach
  void setUp() {
    user = new User("Richard Stallman"); // crea un usuario de prueba
    paymentProcessor = new PaymentProcessor(creditCardPayment, bankTransferPayment, paymentHistory); // Inyecta los Mocks
  }

  @Test
  void testProcessPayment_CreditCard_Success() {
    given(creditCardPayment.process(100.0, user)).willReturn(true);
    boolean result = paymentProcessor.processPayment(100, user, "CreditCard");
    assertTrue(result); // Verificamos que el resultado sea exitoso
    verify(creditCardPayment).process(100.0, user);
    verify(paymentHistory).add(any(Payment.class));
    
  }

  @Test
  void testProcessPayment_BankTransfer_Success() {
    given(bankTransferPayment.process(200.0, user)).willReturn(true);
    boolean result = paymentProcessor.processPayment(200, user, "BankTransfer");
    assertTrue(result); // Verificamos que el resultado sea exitoso
    verify(bankTransferPayment).process(200.0, user);
    verify(paymentHistory).add(any(Payment.class));
    
  }

  @Test
  void testProcessPayment_InvalidAmount() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> paymentProcessor.processPayment(0, user, "CreditCard"));

    // Verificar el mensaje de la excepción
    assertEquals("Invalid amount or user", exception.getMessage());
  }

  @Test
  void testProcessPayment_NullUser() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> paymentProcessor.processPayment(100, null, "CreditCard"));

    // Verificar el mensaje de la excepción
    assertEquals("Invalid amount or user", exception.getMessage());
  }
}

