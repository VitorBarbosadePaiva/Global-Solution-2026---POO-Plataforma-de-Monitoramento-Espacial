package main;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaMonitoramento {

    private static final List<Sensor> sensores = new ArrayList<>();
    private static final DadosMissao dadosMissao = new DadosMissao("senha123");
    private static final PropulsaoQuimica propulsaoQuimica = new PropulsaoQuimica();
    private static final PropulsaoEletrica propulsaoEletrica = new PropulsaoEletrica();

    public static void main(String[] args) {
        inicializarSensores();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        System.out.println("🚀 BEM-VINDO À PLATAFORMA DE MONITORAMENTO ESPACIAL 2026 🚀\n");

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1 -> verificarSensores();
                case 2 -> controlarPropulsao(scanner);
                case 3 -> gerenciarDadosMissao(scanner);
                case 4 -> simularAlertas();
                case 5 -> exibirStatusCompleto();
                case 0 -> System.out.println("👋 Encerrando sistema... Até a próxima missão!");
                default -> System.out.println("❌ Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void inicializarSensores() {
        sensores.add(new SensorTemperatura());
        sensores.add(new SensorPressao());
        sensores.add(new SensorRadiacao());
    }

    private static void exibirMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("               MENU PRINCIPAL");
        System.out.println("=".repeat(50));
        System.out.println("1️⃣  Verificar Sensores");
        System.out.println("2️⃣  Controlar Propulsão");
        System.out.println("3️⃣  Gerenciar Dados da Missão");
        System.out.println("4️⃣  Simular Alertas");
        System.out.println("5️⃣  Exibir Status Completo");
        System.out.println("0️⃣  Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void verificarSensores() {
        System.out.println("\n📡 --- LEITURA DE SENSORES ---");
        for (Sensor sensor : sensores) {
            double valor = sensor.lerValor();
            boolean funcionando = sensor.verificarFuncionamento();

            System.out.printf("%s: %.2f | Funcionando: %s%n", 
                sensor.getTipo(), valor, funcionando ? "✅" : "❌");

            if (!funcionando) {
                System.out.println("   ⚠️  ALERTA: Sensor com problema!");
            }
        }
    }

    private static void controlarPropulsao(Scanner scanner) {
        System.out.println("\n🚀 --- CONTROLE DE PROPULSÃO ---");
        System.out.println("1. Propulsão Química");
        System.out.println("2. Propulsão Elétrica");
        System.out.print("Escolha: ");
        int tipo = scanner.nextInt();

        System.out.print("Digite a potência (0-100%): ");
        double potencia = scanner.nextDouble();

        if (tipo == 1) {
            propulsaoQuimica.ligar();
            propulsaoQuimica.acelerar(potencia);
        } else if (tipo == 2) {
            propulsaoEletrica.ligar();
            propulsaoEletrica.acelerar(potencia);
        } else {
            System.out.println("Tipo inválido!");
        }
    }

    private static void gerenciarDadosMissao(Scanner scanner) {
        System.out.println("\n📋 --- DADOS DA MISSÃO ---");
        System.out.println("1. Ver coordenadas (requer senha)");
        System.out.println("2. Alterar nível de combustível");
        System.out.println("3. Ver informações gerais");
        System.out.print("Escolha: ");
        int op = scanner.nextInt();
        scanner.nextLine();

        if (op == 1) {
            System.out.print("Digite a senha: ");
            String senha = scanner.nextLine();
            System.out.println("Coordenadas: " + dadosMissao.getCoordenadas(senha));
        } 
        else if (op == 2) {
            System.out.print("Novo nível de combustível (0-100): ");
            double nivel = scanner.nextDouble();
            dadosMissao.setNivelCombustivel(nivel);
        } 
        else if (op == 3) {
            System.out.println("Tripulantes: " + dadosMissao.getNumeroTripulantes());
            System.out.println("Trajetória: " + dadosMissao.getTrajetoria());
            System.out.println("Combustível: " + dadosMissao.getNivelCombustivel() + "%");
        }
    }

    private static void simularAlertas() {
        System.out.println("\n🚨 --- SIMULAÇÃO DE ALERTAS ---");
        
        // Teste de temperatura alta
        SensorTemperatura tempSensor = (SensorTemperatura) sensores.get(0);
        for (int i = 0; i < 3; i++) {
            double valor = tempSensor.lerValor();
            if (valor > 60) {
                System.out.println("🔴 CRÍTICO: Temperatura muito alta! (" + String.format("%.1f", valor) + "°C)");
            } else if (valor > 45) {
                System.out.println("🟡 ATENÇÃO: Temperatura elevada (" + String.format("%.1f", valor) + "°C)");
            }
        }

        if (dadosMissao.getNivelCombustivel() < 25) {
            System.out.println("⚠️  ALERTA: Combustível crítico!");
        }
    }

    private static void exibirStatusCompleto() {
        System.out.println("\n📊 --- STATUS COMPLETO DA ESTAÇÃO ESPACIAL ---");
        System.out.println("=".repeat(60));
        
        verificarSensores();
        
        System.out.println("\n🚀 Propulsão Química: " + (propulsaoQuimica.isLigado() ? "Ligada" : "Desligada") 
                + " | Potência: " + propulsaoQuimica.getPotenciaAtual() + "%");
        
        System.out.println("⚡ Propulsão Elétrica: " + (propulsaoEletrica.isLigado() ? "Ligada" : "Desligada") 
                + " | Potência: " + propulsaoEletrica.getPotenciaAtual() + "%");
        
        System.out.println("\n⛽ Combustível: " + dadosMissao.getNivelCombustivel() + "%");
    }
}