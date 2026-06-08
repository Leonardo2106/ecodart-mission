package br.com.ecodartmission.propulsao;

public abstract class SistemaPropulsao {
    private String modelo;
    private boolean ligado;
    private double potenciaAtual;
    private double empuxoBase;

    public SistemaPropulsao(String modelo, double empuxoBase) {
        this.modelo = modelo;
        this.empuxoBase = empuxoBase;
        this.ligado = false;
        this.potenciaAtual = 0;
    }

    public void ligar() {
        this.ligado = true;
        System.out.println(modelo + " ligado.");
    }

    public void desligar() {
        this.ligado = false;
        this.potenciaAtual = 0;
        System.out.println(modelo + " desligado.");
    }

    public abstract void acelerar(double potencia);

    public double calcularEmpuxo() {
        return empuxoBase * (potenciaAtual / 100.0);
    }

    protected boolean validarPotencia(double potencia) {
        if (!ligado) {
            System.out.println("Erro: ligue o sistema de propulsão antes de acelerar.");
            return false;
        }
        if (potencia < 0 || potencia > 100) {
            System.out.println("Erro: potência deve estar entre 0 e 100%.");
            return false;
        }
        return true;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean isLigado() {
        return ligado;
    }

    public double getPotenciaAtual() {
        return potenciaAtual;
    }

    protected void setPotenciaAtual(double potenciaAtual) {
        this.potenciaAtual = potenciaAtual;
    }

    public void exibirStatus() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Status: " + (ligado ? "Ligado" : "Desligado"));
        System.out.println("Potência atual: " + potenciaAtual + "%");
        System.out.printf("Empuxo gerado: %.2f N%n", calcularEmpuxo());
    }
}
