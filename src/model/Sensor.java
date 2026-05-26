package model;

public interface Sensor {
    double lerValor();
    boolean verificarFuncionamento();
    String getTipo();
    void calibrar();
}