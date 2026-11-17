package es.daw;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConversorTemperaturaTest {
    @Test
    void ceroGradosCelsiusDebeSer32Fahrenheit() {
        ConversorTemperatura conversor = new ConversorTemperatura();
        double resultado = conversor.celsiusAFahrenheit(0);
        assertEquals(32.0, resultado, 0.001);
    }
    @Test
    void temperaturaInferiorAlCeroAbsolutoDebeLanzarExcepcion() {
        ConversorTemperatura conversor = new ConversorTemperatura();
        assertThrows(
            IllegalArgumentException.class,
            () -> conversor.celsiusAFahrenheit(-300)
        );
    }

    @Test
    void cienGradosCelsiusDebeSer212Fahrenheit() {
        ConversorTemperatura conversor = new ConversorTemperatura();
        assertEquals(
            212.0,
            conversor.celsiusAFahrenheit(100),
            0.001
        );
    }
}