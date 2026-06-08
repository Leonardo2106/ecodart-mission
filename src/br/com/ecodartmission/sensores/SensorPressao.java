package br.com.ecodartmission.sensores;

import java.util.Random;

public class SensorPressao implements Sensor {
    private double limiteAlerta;
    private final Random random = new Random();

    public SensorPressao(double limiteAlerta) {
        this.limiteAlerta = limiteAlerta;
    }

    @Override
    public double lerValor() {
        return 10 + random.nextDouble() * 190; // 10 a 200 kPa
    }

    @Override
    public boolean verificarFuncionamento() {
        return true;
    }

    @Override
    public String retornarTipo() {
        return "Sensor de Pressão";
    }

    @Override
    public double getLimiteAlerta() {
        return limiteAlerta;
    }

    @Override
    public void setLimiteAlerta(double limiteAlerta) {
        if (limiteAlerta <= 0) {
            System.out.println("Limite inválido para pressão.");
            return;
        }
        this.limiteAlerta = limiteAlerta;
    }
}
