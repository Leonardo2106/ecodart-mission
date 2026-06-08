package br.com.ecodartmission.components;

public class ModuloComunicacao extends ComponenteEspacial {
    private int intensidadeSinal;

    public ModuloComunicacao(String id, String nome, double temperatura, int intensidadeSinal) {
        super(id, nome, temperatura);
        setIntensidadeSinal(intensidadeSinal);
    }

    @Override
    public void diagnosticar() {
        System.out.println("\n--- Diagnóstico do Módulo de Comunicação ---");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Status: " + getStatus());
        System.out.println("Temperatura: " + getTemperatura() + " °C");
        System.out.println("Intensidade do sinal: " + intensidadeSinal + "%");

        if (intensidadeSinal < 30) {
            System.out.println("ALERTA: sinal de comunicação fraco.");
        } else {
            System.out.println("Comunicação operando normalmente.");
        }
    }

    public int getIntensidadeSinal() {
        return intensidadeSinal;
    }

    public void setIntensidadeSinal(int intensidadeSinal) {
        if (intensidadeSinal < 0 || intensidadeSinal > 100) {
            System.out.println("Intensidade do sinal deve estar entre 0 e 100.");
            return;
        }
        this.intensidadeSinal = intensidadeSinal;
    }
}
