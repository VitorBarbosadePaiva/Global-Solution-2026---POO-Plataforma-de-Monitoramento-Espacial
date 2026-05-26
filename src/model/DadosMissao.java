package model;

public class DadosMissao {
    private String coordenadas;
    private double nivelCombustivel;
    private int numeroTripulantes;
    private String codigoAcesso;
    private String trajetoria;

    public DadosMissao(String codigoAcesso) {
        this.codigoAcesso = codigoAcesso;
        this.nivelCombustivel = 100.0;
        this.numeroTripulantes = 12;
        this.coordenadas = "00.000, 00.000";
        this.trajetoria = "Terra → Estação Espacial";
    }

    // Acesso protegido por senha
    public String getCoordenadas(String senha) {
        if (senha.equals(codigoAcesso)) {
            return coordenadas;
        }
        return "Acesso negado!";
    }

    public void setNivelCombustivel(double nivel) {
        if (nivel >= 0 && nivel <= 100) {
            this.nivelCombustivel = nivel;
            if (nivel < 20) {
                System.out.println("⚠️ ALERTA: Nível de combustível baixo! (" + nivel + "%)");
            }
        } else {
            System.out.println("Valor inválido para combustível.");
        }
    }

    public double getNivelCombustivel() {
        return nivelCombustivel;
    }

    // Getters
    public int getNumeroTripulantes() { return numeroTripulantes; }
    public String getTrajetoria() { return trajetoria; }
}