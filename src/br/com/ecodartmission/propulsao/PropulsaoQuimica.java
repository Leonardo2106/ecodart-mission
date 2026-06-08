package br.com.ecodartmission.propulsao;

public class PropulsaoQuimica extends SistemaPropulsao {
    private String tipoCombustivel;
    private double eficienciaCombustao;

    public PropulsaoQuimica(String modelo, double empuxoBase, String tipoCombustivel, double eficienciaCombustao) {
        super(modelo, empuxoBase);
        this.tipoCombustivel = tipoCombustivel;
        this.eficienciaCombustao = eficienciaCombustao;
    }

    @Override
    public void acelerar(double potencia) {
        if (!validarPotencia(potencia)) {
            return;
        }
        setPotenciaAtual(potencia);
        System.out.println("Propulsão química acelerando com combustão de " + tipoCombustivel + ".");
        System.out.printf("Empuxo ajustado: %.2f N%n", calcularEmpuxo() * eficienciaCombustao);
    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("Tipo de combustível: " + tipoCombustivel);
        System.out.println("Eficiência de combustão: " + eficienciaCombustao);
    }
}
