package model;

import java.util.Random;

public class SensorRadiacao implements Sensor {
    private double nivelRadiacao;
    private final Random random = new Random();

    @Override
    public double lerValor() {
        nivelRadiacao = random.nextDouble() * 50; // 0 a 50 mSv
        return nivelRadiacao;
    }

    @Override
    public boolean verificarFuncionamento() {
        return nivelRadiacao < 40;
    }

    @Override
    public String getTipo() {
        return "Radiação";
    }

    @Override
    public void calibrar() {
        System.out.println("Sensor de Radiação calibrado.");
    }
}