package model;

public abstract class SistemaPropulsao {
    protected String tipo;
    protected double potenciaAtual;
    protected boolean ligado;

    public SistemaPropulsao(String tipo) {
        this.tipo = tipo;
        this.potenciaAtual = 0;
        this.ligado = false;
    }

    public void ligar() {
        this.ligado = true;
        System.out.println(tipo + " ligado.");
    }

    public void desligar() {
        this.ligado = false;
        this.potenciaAtual = 0;
        System.out.println(tipo + " desligado.");
    }

    public abstract void acelerar(double porcentagem);

    public double getPotenciaAtual() {
        return potenciaAtual;
    }

    public boolean isLigado() {
        return ligado;
    }
}