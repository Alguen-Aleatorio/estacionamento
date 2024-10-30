package genrenciamento;

import java.time.LocalDateTime;

public class Veiculo {
 private String placa;
 private String modelo;
 private String tamanho; // "pequeno", "medio", ou "grande"
 private LocalDateTime horaEntrada;
 private LocalDateTime horaSaida;

 public Veiculo(String placa, String modelo, String tamanho) {
     this.placa = placa;
     this.modelo = modelo;
     this.tamanho = tamanho;
     this.horaEntrada = LocalDateTime.now();
 }

 public String getPlaca() {
     return placa;
 }

 public String getModelo() {
     return modelo;
 }

 public String getTamanho() {
     return tamanho;
 }

 public LocalDateTime getHoraEntrada() {
     return horaEntrada;
 }

 public void setHoraSaida(LocalDateTime horaSaida) {
     this.horaSaida = horaSaida;
 }

 public LocalDateTime getHoraSaida() {
     return horaSaida;
 }

 @Override
 public String toString() {
     return "Veículo " + placa + " (" + modelo + ", " + tamanho + ")";
 }
}