package es.daw;

public class ConversorTemperatura {
    public double celsiusAFahrenheit(double celsius) {
        if (celsius < -273.15) {
            throw new IllegalArgumentException(
            "Temperatura inferior al cero absoluto."
            );
        }
        return (celsius * 9 / 5) + 32;
    }
}