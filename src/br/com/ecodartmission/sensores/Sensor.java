package br.com.ecodartmission.sensores;

public interface Sensor {
    double lerValor();
    boolean verificarFuncionamento();
    String retornarTipo();
    double getLimiteAlerta();
    void setLimiteAlerta(double limiteAlerta);
}
