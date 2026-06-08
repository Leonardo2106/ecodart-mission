package br.com.ecodartmission.main;

import br.com.ecodartmission.components.ModuloComunicacao;
import br.com.ecodartmission.missao.DadosMissao;
import br.com.ecodartmission.propulsao.PropulsaoEletrica;
import br.com.ecodartmission.propulsao.PropulsaoQuimica;
import br.com.ecodartmission.propulsao.SistemaPropulsao;
import br.com.ecodartmission.sensores.Sensor;
import br.com.ecodartmission.sensores.SensorPressao;
import br.com.ecodartmission.sensores.SensorRadiacao;
import br.com.ecodartmission.sensores.SensorTemperatura;

import java.util.Scanner;

public class SistemaMonitoramento {
    private static final Scanner scanner = new Scanner(System.in);

    private static final Sensor[] sensores = {
            new SensorTemperatura(80),
            new SensorPressao(150),
            new SensorRadiacao(6)
    };

    private static final SistemaPropulsao propulsaoQuimica = new PropulsaoQuimica("PQ-900", 50000, "Hidrogênio Líquido", 1.15);
    private static final SistemaPropulsao propulsaoEletrica = new PropulsaoEletrica("PE-ION-300", 12000, 400, 1.30);
    private static final DadosMissao dadosMissao = new DadosMissao("X: 352 | Y: 881 | Z: 119", "1234", 75, "Órbita baixa da Terra", 4);
    private static final ModuloComunicacao moduloComunicacao = new ModuloComunicacao("COM-01", "Módulo de Comunicação Orbital", 32, 82);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> verificarSensores();
                case 2 -> controlarPropulsao();
                case 3 -> gerenciarDadosMissao();
                case 4 -> simularAlertas();
                case 5 -> exibirStatusCompleto();
                case 0 -> System.out.println("Encerrando sistema de monitoramento espacial...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n========= SISTEMA DE MONITORAMENTO ESPACIAL =========");
        System.out.println("1 - Verificar sensores");
        System.out.println("2 - Controlar propulsão");
        System.out.println("3 - Gerenciar dados da missão");
        System.out.println("4 - Simular alertas");
        System.out.println("5 - Exibir status completo");
        System.out.println("0 - Sair");
    }

    private static void verificarSensores() {
        System.out.println("\n--- Verificação de Sensores ---");
        for (Sensor sensor : sensores) {
            double valor = sensor.lerValor();
            System.out.println("Tipo: " + sensor.retornarTipo());
            System.out.printf("Valor lido: %.2f%n", valor);
            System.out.println("Funcionamento: " + (sensor.verificarFuncionamento() ? "OK" : "Falha"));
            verificarAlerta(valor, sensor.getLimiteAlerta());
            System.out.println();
        }
    }

    private static void controlarPropulsao() {
        System.out.println("\n--- Controle de Propulsão ---");
        System.out.println("1 - Propulsão Química");
        System.out.println("2 - Propulsão Elétrica");
        int tipo = lerInteiro("Escolha o tipo de propulsão: ");

        SistemaPropulsao propulsao = tipo == 1 ? propulsaoQuimica : propulsaoEletrica;

        System.out.println("1 - Ligar");
        System.out.println("2 - Desligar");
        System.out.println("3 - Acelerar");
        System.out.println("4 - Exibir status");
        int acao = lerInteiro("Escolha a ação: ");

        switch (acao) {
            case 1 -> propulsao.ligar();
            case 2 -> propulsao.desligar();
            case 3 -> {
                double potencia = lerDouble("Digite a potência de aceleração (0 a 100): ");
                propulsao.acelerar(potencia);
            }
            case 4 -> propulsao.exibirStatus();
            default -> System.out.println("Ação inválida.");
        }
    }

    private static void gerenciarDadosMissao() {
        System.out.println("\n--- Dados da Missão ---");
        System.out.println("1 - Exibir dados públicos");
        System.out.println("2 - Ver coordenadas protegidas");
        System.out.println("3 - Alterar coordenadas protegidas");
        System.out.println("4 - Alterar combustível");
        System.out.println("5 - Alterar trajetória");
        System.out.println("6 - Alterar número de tripulantes");
        int opcao = lerInteiro("Escolha a opção: ");

        switch (opcao) {
            case 1 -> dadosMissao.exibirDadosPublicos();
            case 2 -> {
                System.out.print("Digite o código de acesso: ");
                String codigo = scanner.nextLine();
                System.out.println("Coordenadas: " + dadosMissao.getCoordenadas(codigo));
            }
            case 3 -> {
                System.out.print("Digite o código de acesso: ");
                String codigo = scanner.nextLine();
                System.out.print("Digite as novas coordenadas: ");
                String coordenadas = scanner.nextLine();
                dadosMissao.setCoordenadas(coordenadas, codigo);
            }
            case 4 -> {
                double combustivel = lerDouble("Novo nível de combustível (0 a 100): ");
                dadosMissao.setNivelCombustivel(combustivel);
            }
            case 5 -> {
                System.out.print("Nova trajetória: ");
                String trajetoria = scanner.nextLine();
                dadosMissao.setTrajetoria(trajetoria);
            }
            case 6 -> {
                int tripulantes = lerInteiro("Número de tripulantes: ");
                dadosMissao.setNumeroTripulantes(tripulantes);
            }
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void simularAlertas() {
        System.out.println("\n--- Simulação de Alertas ---");
        System.out.println("Simulando temperatura crítica, pressão elevada, radiação alta e combustível baixo...");
        verificarAlerta(95, 80);
        verificarAlerta(170, 150);
        verificarAlerta(9, 6);
        dadosMissao.setNivelCombustivel(15);
    }

    private static void exibirStatusCompleto() {
        System.out.println("\n========== STATUS COMPLETO ==========");
        moduloComunicacao.ligar();
        moduloComunicacao.diagnosticar();
        verificarSensores();
        propulsaoQuimica.exibirStatus();
        System.out.println();
        propulsaoEletrica.exibirStatus();
        dadosMissao.exibirDadosPublicos();
    }

    private static void verificarAlerta(double valor, double limite) {
        if (valor >= limite * 1.5) {
            System.out.println("CRÍTICO: valor muito acima do limite!");
        } else if (valor >= limite * 1.2) {
            System.out.println("ALERTA: valor acima do limite seguro.");
        } else if (valor > limite) {
            System.out.println("ATENÇÃO: valor ultrapassou o limite.");
        } else {
            System.out.println("Status: valor dentro do limite.");
        }
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                int valor = Integer.parseInt(scanner.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static double lerDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                double valor = Double.parseDouble(scanner.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }
}
