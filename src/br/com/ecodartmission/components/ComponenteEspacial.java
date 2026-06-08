package br.com.ecodartmission.components;

public abstract class ComponenteEspacial {
    private String id;
    private String nome;
    private boolean ligado;
    private double temperatura;

    public ComponenteEspacial(String id, String nome, double temperatura) {
        this.id = id;
        this.nome = nome;
        this.temperatura = temperatura;
        this.ligado = false;
    }

    public void ligar() {
        this.ligado = true;
        System.out.println(nome + " foi ligado.");
    }

    public void desligar() {
        this.ligado = false;
        System.out.println(nome + " foi desligado.");
    }

    public abstract void diagnosticar();

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isLigado() {
        return ligado;
    }

    public String getStatus() {
        return ligado ? "Ligado" : "Desligado";
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        if (temperatura < -273.15) {
            System.out.println("Temperatura inválida.");
            return;
        }
        this.temperatura = temperatura;
    }
}
