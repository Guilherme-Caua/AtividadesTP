package br.edu.fatecpg.polimorfismo.model;

public class Conversor {

    // Celsius para Fahrenheit
    public double converter(double celsius) {
        return celsius * 9.0 / 5.0 + 32;
    }

    // Quilômetros para Milhas
    public double converter(double km, boolean paraMilhas) {
        return km * 0.621371;
    }

    // String para maiúsculas
    public String converter(String texto) {
        return texto.toUpperCase();
    }
}
