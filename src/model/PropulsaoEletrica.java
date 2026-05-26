package model;

public class PropulsaoEletrica extends SistemaPropulsao {

    public PropulsaoEletrica() {
        super("Propulsão Elétrica");
    }

    @Override
    public void acelerar(double porcentagem) {
        if (porcentagem > 0 && porcentagem <= 100) {
            this.potenciaAtual = porcentagem * 0.85; // Menos eficiente
            System.out.println("Propulsão Elétrica acelerando a " + porcentagem + "% - Baixo consumo.");
        }
    }
}