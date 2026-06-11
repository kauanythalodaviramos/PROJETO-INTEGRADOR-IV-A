package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private final Calculadora calculadora = new Calculadora();

    @Test
    void testSomar() {
        assertEquals(5.0, calculadora.somar(2.0, 3.0), "Soma de dois positivos");
        assertEquals(-5.0, calculadora.somar(-2.0, -3.0), "Soma de dois negativos");
        assertEquals(0.0, calculadora.somar(0.0, 0.0), "Soma com zeros");
        assertEquals(5.0, calculadora.somar(5.0, 0.0), "Soma de positivo com zero");
    }

    @Test
    void testSubtrair() {
        assertEquals(2.0, calculadora.subtrair(5.0, 3.0), "Subtração de dois positivos");
        assertEquals(1.0, calculadora.subtrair(-2.0, -3.0), "Subtração de dois negativos");
        assertEquals(0.0, calculadora.subtrair(0.0, 0.0), "Subtração com zeros");
        assertEquals(5.0, calculadora.subtrair(5.0, 0.0), "Subtração de positivo com zero");
    }

    @Test
    void testMultiplicar() {
        assertEquals(6.0, calculadora.multiplicar(2.0, 3.0), "Multiplicação de dois positivos");
        assertEquals(6.0, calculadora.multiplicar(-2.0, -3.0), "Multiplicação de dois negativos");
        assertEquals(0.0, calculadora.multiplicar(0.0, 0.0), "Multiplicação com zeros");
        assertEquals(0.0, calculadora.multiplicar(5.0, 0.0), "Multiplicação por zero");
    }

    @Test
    void testDividir() {
        assertEquals(2.5, calculadora.dividir(5.0, 2.0), "Divisão bem-sucedida");
        assertEquals(2.0, calculadora.dividir(-10.0, -5.0), "Divisão de negativos");
    }

    @Test
    void testDividirPorZeroDeveLancarExcecao() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculadora.dividir(10.0, 0.0),
            "Deve lançar IllegalArgumentException para divisão por zero"
        );

        assertEquals("Não é possível dividir por zero.", exception.getMessage());
    }
}
