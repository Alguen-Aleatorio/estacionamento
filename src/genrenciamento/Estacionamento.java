package genrenciamento;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
 private List<Vaga> vagas;
 private List<Veiculo> historico;

 public Estacionamento() {
     vagas = new ArrayList<>();
     historico = new ArrayList<>();
 }

 public void cadastrarVaga(int numero, String tamanho) {
     Vaga vaga = new Vaga(numero, tamanho);
     vagas.add(vaga);
     System.out.println("Vaga " + numero + " cadastrada com sucesso.");
 }

 public void listarVagas() {
     System.out.println("\nLista de Vagas:");
     for (Vaga vaga : vagas) {
         System.out.println(vaga);
     }
 }

 public void registrarEntradaVeiculo(Veiculo veiculo) {
     for (Vaga vaga : vagas) {
         if (vaga.isDisponivel() && vaga.getTamanho().equalsIgnoreCase(veiculo.getTamanho())) {
             vaga.setDisponibilidade(false);
             veiculo.setHoraSaida(null); // Reset hora de saída
             historico.add(veiculo);
             System.out.println("Veículo " + veiculo.getPlaca() + " entrou na vaga " + vaga.getNumero() + ".");
             return;
         }
     }
     System.out.println("Nenhuma vaga disponível para o tamanho do veículo.");
 }

 public void registrarSaidaVeiculo(String placa) {
     for (Veiculo veiculo : historico) {
         if (veiculo.getPlaca().equalsIgnoreCase(placa) && veiculo.getHoraSaida() == null) {
             veiculo.setHoraSaida(LocalDateTime.now());
             liberarVaga(veiculo.getTamanho());
             calcularValor(veiculo);
             return;
         }
     }
     System.out.println("Veículo não encontrado ou já saiu.");
 }

 private void liberarVaga(String tamanho) {
     for (Vaga vaga : vagas) {
         if (!vaga.isDisponivel() && vaga.getTamanho().equalsIgnoreCase(tamanho)) {
             vaga.setDisponibilidade(true);
             break;
         }
     }
 }

 private void calcularValor(Veiculo veiculo) {
     Duration duracao = Duration.between(veiculo.getHoraEntrada(), veiculo.getHoraSaida());
     long horas = duracao.toHours();
     double valor;
     
     if (horas <= 1) {
         valor = 5.0;
     } else if (horas <= 3) {
         valor = 10.0;
     } else {
         valor = 15.0;
     }

     System.out.println("Veículo " + veiculo.getPlaca() + " ficou por " + horas + " horas. Valor a pagar: R$" + valor);
 }

 public void gerarRelatorioOcupacao() {
     System.out.println("\nRelatório de Vagas Ocupadas:");
     for (Vaga vaga : vagas) {
         if (!vaga.isDisponivel()) {
             System.out.println(vaga);
         }
     }
 }

 public void gerarHistorico() {
     System.out.println("\nHistórico de Permanência de Veículos:");
     for (Veiculo veiculo : historico) {
         if (veiculo.getHoraSaida() != null) {
             System.out.println(veiculo + " - Entrada: " + veiculo.getHoraEntrada() + ", Saída: " + veiculo.getHoraSaida());
         }
     }
 }
}