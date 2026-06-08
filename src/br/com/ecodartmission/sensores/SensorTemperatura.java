package br.com.ecodartmission.sensores;

import java.util.Random;

public class SensorTemperatura implements Sensor {
    private double limiteAlerta;
    private final Random random = new Random();

    public SensorTemperatura(double limiteAlerta) {
        this.limiteAlerta = limiteAlerta;
    }

    @Override
    public double lerValor() {
        return -20 + random.nextDouble() * 140; // -20°C a 120°C
    }

    @Override
    public boolean verificarFuncionamento() {
        return true;
    }

    @Override
    public String retornarTipo() {
        return "Sensor de Temperatura";
    }

    @Override
    public double getLimiteAlerta() {
        return limiteAlerta;
    }

    @Override
    public void setLimiteAlerta(double limiteAlerta) {
        if (limiteAlerta <= 0) {
            System.out.println("Limite inválido para temperatura.");
            return;
        }
        this.limiteAlerta = limiteAlerta;
    }
}
