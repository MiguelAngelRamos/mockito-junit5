# ACTIVIDAD: Testing de un Sistema de Procesamiento de Pagos

**Objetivo:**
Aplicar pruebas unitarias, uso de Mocks con Mockito y buenas prácticas de TDD para validar la lógica de un sistema de procesamiento de pagos. El estudiante debe demostrar aislamiento de dependencias, verificación de interacciones y pruebas efectivas.

## Instrucciones

1. Crea un proyecto llamado `PaymentProcessor`.
   - Este proyecto simulará un sistema que permite procesar pagos por distintos métodos (tarjeta de crédito, transferencia bancaria).


2. Funciones a implementar:
   - **Procesar pago:**  
     Recibe monto, usuario y método de pago.  
     Valida que el monto sea positivo y el usuario no sea nulo.  
     Determina el método (tarjeta o transferencia) y utiliza el canal apropiado para procesar.
   - **Validar datos:**  
     No debe procesar si el monto es cero/negativo o el usuario es nulo.
   - **Obtener historial de pagos:**  
     Registra cada pago con fecha, usuario, monto y método utilizado.

3. Implementa pruebas unitarias que incluyan:
   - Mocks para los métodos de pago.
   - Uso de `@Mock`, `@InjectMocks`, `@Captor`.
   - Verificación de llamadas con `verify()`.
   - Lanzamiento de excepciones desde los mocks.
   - Sintaxis BDD (`given`, `when`, `then`).
