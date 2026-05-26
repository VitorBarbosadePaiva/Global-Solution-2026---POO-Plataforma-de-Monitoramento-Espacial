package model;

import java.util.Random;

public class SensorTemperatura implements Sensor {
    private double temperaturaAtual;
    private final Random random = new Random();

    @Override
    public double lerValor() {
        temperaturaAtual = 15 + random.nextDouble() * 60; // 15 a 75°C
        return temperaturaAtual;
    }

    @Override
    public boolean verificarFuncionamento() {
        return temperaturaAtual < 100;
    }

    @Override
    public String getTipo() {
        return "Temperatura";
    }

    @Override
    public void calibrar() {
        System.out.println("Sensor de Temperatura calibrado.");
    }
}