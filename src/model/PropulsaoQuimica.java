package model;

public class PropulsaoQuimica extends SistemaPropulsao {

    public PropulsaoQuimica() {
        super("Propulsão Química");
    }

    @Override
    public void acelerar(double porcentagem) {
        if (porcentagem > 0 && porcentagem <= 100) {
            this.potenciaAtual = porcentagem;
            System.out.println("Propulsão Química acelerando a " + porcentagem + "% - Alto empuxo!");
        }
    }
}