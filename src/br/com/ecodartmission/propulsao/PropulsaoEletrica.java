package br.com.ecodartmission.propulsao;

public class PropulsaoEletrica extends SistemaPropulsao {
    private double consumoEnergia;
    private double eficienciaIonica;

    public PropulsaoEletrica(String modelo, double empuxoBase, double consumoEnergia, double eficienciaIonica) {
        super(modelo, empuxoBase);
        this.consumoEnergia = consumoEnergia;
        this.eficienciaIonica = eficienciaIonica;
    }

    @Override
    public void acelerar(double potencia) {
        if (!validarPotencia(potencia)) {
            return;
        }
        setPotenciaAtual(potencia);
        System.out.println("Propulsão elétrica acelerando com motor iônico.");
        System.out.printf("Consumo estimado: %.2f kW%n", consumoEnergia * (potencia / 100.0));
        System.out.printf("Empuxo ajustado: %.2f N%n", calcularEmpuxo() * eficienciaIonica);
    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("Consumo máximo de energia: " + consumoEnergia + " kW");
        System.out.println("Eficiência iônica: " + eficienciaIonica);
    }
}
