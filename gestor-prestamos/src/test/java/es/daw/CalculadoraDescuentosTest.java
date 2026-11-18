package es.daw;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraDescuentosTest {

    @Test
    public void testDescuentoDel20PorCiento() {
        CalculadoraDescuentos calculadora = new CalculadoraDescuentos();

        double resultado = calculadora.calcularPrecioFinal(100, 20);

        assertEquals(80, resultado);
    }

    @Test
    public void testDescuentoDelCeroPorCiento() {
        CalculadoraDescuentos calculadora = new CalculadoraDescuentos();

        double resultado = calculadora.calcularPrecioFinal(50, 0);

        assertEquals(50, resultado);
    }

    @Test
    public void testDescuentoDel100PorCiento() {
        CalculadoraDescuentos calculadora = new CalculadoraDescuentos();

        double resultado = calculadora.calcularPrecioFinal(50, 100);

        assertEquals(0, resultado);
    }

    @Test
    public void testPrecioNegativo() {
        CalculadoraDescuentos calculadora = new CalculadoraDescuentos();

        assertThrows(IllegalArgumentException.class, () ->
            calculadora.calcularPrecioFinal(-10, 20)
        );
    }

    @Test
    public void testDescuentoNegativo() {
        CalculadoraDescuentos calculadora = new CalculadoraDescuentos();

        assertThrows(IllegalArgumentException.class, () ->
            calculadora.calcularPrecioFinal(50, -10)
        );
    }

    @Test
    public void testDescuentoSuperiorA100() {
        CalculadoraDescuentos calculadora = new CalculadoraDescuentos();

        assertThrows(IllegalArgumentException.class, () ->
            calculadora.calcularPrecioFinal(50, 110)
        );
    }

    @Test
    public void testPrecioIgualACero() {
        CalculadoraDescuentos calculadora = new CalculadoraDescuentos();

        double resultado = calculadora.calcularPrecioFinal(0, 20);

        assertEquals(0, resultado);
    }

    @Test
    public void testDescuentoExactamenteIgualA100() {
        CalculadoraDescuentos calculadora = new CalculadoraDescuentos();

        double resultado = calculadora.calcularPrecioFinal(100, 100);

        assertEquals(0, resultado);
    }

    @Test
    public void testPrecioConDecimales() {
        CalculadoraDescuentos calculadora = new CalculadoraDescuentos();

        double resultado = calculadora.calcularPrecioFinal(99.99, 10);

        assertEquals(89.991, resultado, 0.001);
    }

    @Test
    public void testDescuentoConDecimales() {
        CalculadoraDescuentos calculadora = new CalculadoraDescuentos();

        double resultado = calculadora.calcularPrecioFinal(100, 12.5);

        assertEquals(87.5, resultado, 0.001);
    }

}
