package br.com.ecodartmission.sensores;

import java.util.Random;

public class SensorRadiacao implements Sensor {
    private double limiteAlerta;
    private final Random random = new Random();

    public SensorRadiacao(double limiteAlerta) {
        this.limiteAlerta = limiteAlerta;
    }

    @Override
    public double lerValor() {
        return random.nextDouble() * 12; // 0 a 12 mSv/h
    }

    @Override
    public boolean verificarFuncionamento() {
        return true;
    }

    @Override
    public String retornarTipo() {
        return "Sensor de Radiação";
    }

    @Override
    public double getLimiteAlerta() {
        return limiteAlerta;
    }

    @Override
    public void setLimiteAlerta(double limiteAlerta) {
        if (limiteAlerta <= 0) {
            System.out.println("Limite inválido para radiação.");
            return;
        }
        this.limiteAlerta = limiteAlerta;
    }
}
