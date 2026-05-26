package model;

public abstract class ComponenteEspacial {
    private String id;
    private String nome;
    private String status; // "Ativo", "Inativo", "Em Falha"
    private double temperatura;

    public ComponenteEspacial(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.status = "Inativo";
        this.temperatura = 20.0;
    }

    public void ligar() {
        this.status = "Ativo";
        System.out.println(nome + " ligado com sucesso.");
    }

    public void desligar() {
        this.status = "Inativo";
        System.out.println(nome + " desligado.");
    }

    // Método abstrato obrigatório
    public abstract void diagnosticar();

    // Getters e Setters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getStatus() { return status; }
    public double getTemperatura() { return temperatura; }

    protected void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
}