package br.com.ecodartmission.missao;

public class DadosMissao {
    private String coordenadas;
    private String codigoAcesso;
    private double nivelCombustivel;
    private String trajetoria;
    private int numeroTripulantes;

    public DadosMissao(String coordenadas, String codigoAcesso, double nivelCombustivel, String trajetoria, int numeroTripulantes) {
        this.coordenadas = coordenadas;
        this.codigoAcesso = codigoAcesso;
        setNivelCombustivel(nivelCombustivel);
        setTrajetoria(trajetoria);
        setNumeroTripulantes(numeroTripulantes);
    }

    public String getCoordenadas(String codigoInformado) {
        if (validarCodigo(codigoInformado)) {
            return coordenadas;
        }
        return "Acesso negado: código incorreto.";
    }

    public void setCoordenadas(String coordenadas, String codigoInformado) {
        if (!validarCodigo(codigoInformado)) {
            System.out.println("Acesso negado: código incorreto.");
            return;
        }
        if (coordenadas == null || coordenadas.trim().isEmpty()) {
            System.out.println("Coordenadas não podem ficar vazias.");
            return;
        }
        this.coordenadas = coordenadas;
        System.out.println("Coordenadas atualizadas com sucesso.");
    }

    public boolean validarCodigo(String codigoInformado) {
        return codigoAcesso.equals(codigoInformado);
    }

    public double getNivelCombustivel() {
        return nivelCombustivel;
    }

    public void setNivelCombustivel(double nivelCombustivel) {
        if (nivelCombustivel < 0 || nivelCombustivel > 100) {
            System.out.println("Nível de combustível deve estar entre 0 e 100.");
            return;
        }
        this.nivelCombustivel = nivelCombustivel;
        if (nivelCombustivel < 20) {
            System.out.println("CRÍTICO: combustível abaixo de 20%.");
        }
    }

    public String getTrajetoria() {
        return trajetoria;
    }

    public void setTrajetoria(String trajetoria) {
        if (trajetoria == null || trajetoria.trim().isEmpty()) {
            System.out.println("Trajetória não pode ficar vazia.");
            return;
        }
        this.trajetoria = trajetoria;
    }

    public int getNumeroTripulantes() {
        return numeroTripulantes;
    }

    public void setNumeroTripulantes(int numeroTripulantes) {
        if (numeroTripulantes < 0) {
            System.out.println("Número de tripulantes não pode ser negativo.");
            return;
        }
        this.numeroTripulantes = numeroTripulantes;
    }

    public void exibirDadosPublicos() {
        System.out.println("\n--- Dados da Missão ---");
        System.out.println("Trajetória: " + trajetoria);
        System.out.println("Tripulantes: " + numeroTripulantes);
        System.out.println("Combustível: " + nivelCombustivel + "%");
    }
}
