package model;

import java.util.Random;

public class SensorPressao implements Sensor {
    private double pressaoAtual;
    private final Random random = new Random();

    @Override
    public double lerValor() {
        pressaoAtual = 0.8 + random.nextDouble() * 0.6; // 0.8 a 1.4 atm
        return pressaoAtual;
    }

    @Override
    public boolean verificarFuncionamento() {
        return pressaoAtual > 0.5 && pressaoAtual < 2.0;
    }

    @Override
    public String getTipo() {
        return "Pressão";
    }

    @Override
    public void calibrar() {
        System.out.println("Sensor de Pressão calibrado.");
    }
}