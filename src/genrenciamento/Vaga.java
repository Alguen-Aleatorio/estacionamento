package genrenciamento;

public class Vaga {

	public Vaga() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

 private int numero;
 private String tamanho; // "pequeno", "medio", ou "grande"
 private boolean disponibilidade;

 public Vaga(int numero, String tamanho) {
     this.numero = numero;
     this.tamanho = tamanho;
     this.disponibilidade = true; // True para disponível, False para ocupada
 }

 public int getNumero() {
     return numero;
 }

 public String getTamanho() {
     return tamanho;
 }

 public boolean isDisponivel() {
     return disponibilidade;
 }

 public void setDisponibilidade(boolean disponibilidade) {
     this.disponibilidade = disponibilidade;
 }

 @Override
 public String toString() {
     return "Vaga " + numero + " (" + tamanho + ") - " + (disponibilidade ? "Disponível" : "Ocupada");
 }
}