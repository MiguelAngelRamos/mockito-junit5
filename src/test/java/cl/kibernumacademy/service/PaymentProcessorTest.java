package cl.kibernumacademy.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
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


}
