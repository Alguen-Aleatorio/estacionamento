package genrenciamento;

import java.util.Scanner;

public class SistemaEstacionamento {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     Estacionamento estacionamento = new Estacionamento();

     while (true) {
         System.out.println("\nMenu:");
         System.out.println("1. Cadastrar Vaga");
         System.out.println("2. Listar Vagas");
         System.out.println("3. Registrar Entrada de Veículo");
         System.out.println("4. Registrar Saída de Veículo");
         System.out.println("5. Relatório de Vagas Ocupadas");
         System.out.println("6. Histórico de Permanência");
         System.out.println("7. Sair");
         System.out.print("Escolha uma opção: ");
         int opcao = scanner.nextInt();
         scanner.nextLine();

         switch (opcao) {
             case 1:
                 System.out.print("Número da vaga: ");
                 int numero = scanner.nextInt();
                 scanner.nextLine();
                 System.out.print("Tamanho da vaga (pequeno, medio, grande): ");
                 String tamanhoVaga = scanner.nextLine();
                 estacionamento.cadastrarVaga(numero, tamanhoVaga);
                 break;
             case 2:
                 estacionamento.listarVagas();
                 break;
             case 3:
                 System.out.print("Placa do veículo: ");
                 String placa = scanner.nextLine();
                 System.out.print("Modelo do veículo: ");
                 String modelo = scanner.nextLine();
                 System.out.print("Tamanho do veículo (pequeno, medio, grande): ");
                 String tamanhoVeiculo = scanner.nextLine();
                 Veiculo veiculo = new Veiculo(placa, modelo, tamanhoVeiculo);
                 estacionamento.registrarEntradaVeiculo(veiculo);
                 break;
             case 4:
                 System.out.print("Placa do veículo para saída: ");
                 String placaSaida = scanner.nextLine();
                 estacionamento.registrarSaidaVeiculo(placaSaida);
                 break;
             case 5:
                 estacionamento.gerarRelatorioOcupacao();
                 break;
             case 6:
                 estacionamento.gerarHistorico();
                 break;
             case 7:
                 System.out.println("Saindo do sistema...");
                 scanner.close();
                 return;
             default:
                 System.out.println("Opção inválida. Tente novamente.");
         }
     }
 }
}