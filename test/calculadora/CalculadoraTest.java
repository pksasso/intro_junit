package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {

    private Calculadora calc;

    @BeforeEach
    public void inicializa() {
        calc = new Calculadora();
    }

    @DisplayName("Soma de dois numeros > 0")
    @Test
    public void testSomaDoisNumerosMaiorQueZero() {
        int soma = calc.soma(4, 5);
        Assertions.assertEquals(9, soma);
    }

    @DisplayName("Soma de dois numeros < 0")
    @Test
    public void testSomaDoisNumerosMenorQueZero() {
        int soma = calc.soma(-4, -5);
        Assertions.assertEquals(-9, soma);
    }

    @DisplayName("Soma de dois numeros sinais opostos")
    @Test
    public void testSomaDoisNumerosSinaisOpostos() {
        int soma = calc.soma(4, -5);
        Assertions.assertEquals(-1, soma);
    }

    @DisplayName("Subtracao de dois numeros > 0")
    @Test
    public void testSubtracaoDoisNumerosMaiorQueZero() {
        int subtracao = calc.subtracao(5, 4);
        Assertions.assertEquals(1, subtracao);
    }

    @DisplayName("Subtracao de dois numeros < 0")
    @Test
    public void testSubtracaoDoisNumerosMenorQueZero() {
        int subtracao = calc.subtracao(-4, -5);
        Assertions.assertEquals(1, subtracao);
    }

    @DisplayName("Subtracao de dois numeros sinais opostos")
    @Test
    public void testSubtracaoDoisNumerosSinaisOpostos() {
        int subtracao = calc.subtracao(-4, 5);
        Assertions.assertEquals(-9, subtracao);
    }

    @DisplayName("Divisao de dois numeros")
    @Test
    public void testDivisaoDoisNumeros() {
        int divisao = calc.divisao(8, 4);
        assertEquals(2, divisao);
    }

    @DisplayName("Divisao de dois numeros")
    @Test
    public void testDivisaoDoisNumerosSinaisOpostos() {
        int divisao = calc.divisao(8, -4);
        assertEquals(-2, divisao);
    }

    @DisplayName("Divisao por zero")
    @Test
    public void testDivisaoPorZero() {
        try {
            int divisao = calc.divisao(8, 0);
            fail("Exce��o n�o lan�ada");
        }catch (ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage());
        }
    }

    @DisplayName("Divisao por zero com Throws")
    @Test
    public void testDivisaoPorZeroComAssertThrows() {
        assertThrows(ArithmeticException.class,
                () -> calc.divisao(8, 0));
    }

    @DisplayName("Somatorio")
    @Test
    public void testSomatoria() {
        int somatoria = calc.somatoria(3);
        assertEquals(6, somatoria);
    }

    @DisplayName("EhPositivo == TRUE")
    @Test
    public void testEhPositivoTrue() {
        boolean ehPositivo = calc.ehPositivo(3);
        assertTrue(ehPositivo);
    }

    @DisplayName("Ehositivo == FALSE")
    @Test
    public void testEhPositivoFalse() {
        boolean ehPositivo = calc.ehPositivo(-3);
        Assertions.assertFalse(ehPositivo);
    }

}
