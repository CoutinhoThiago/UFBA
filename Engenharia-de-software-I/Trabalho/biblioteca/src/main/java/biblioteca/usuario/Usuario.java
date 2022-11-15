package biblioteca.usuario;

import java.util.Random;

import biblioteca.usuario.interfaces.Fncionalidades;

public class Usuario implements Fncionalidades {
	private int id = 0; // código do usuario para facilitar a busca
	private String nome;
	private String sobrenome;
	
	private int tempoDeEmprestimo = 3;
	private int quantidadeDeItensReservados;
	
	private boolean alunoDePosGraduacao;
	private boolean professor;
	
	public void pegarLivroEmprestado() {
	}	
	public void reservarLivro() {
	}

	public int getTempoDeImprestimo() {return tempoDeEmprestimo;}
	public void setTempoDeEmprestimo(int tempoDeImprestimo) {this.tempoDeEmprestimo = tempoDeImprestimo;}
	public int getQuantidadeDeItensReservados() {return quantidadeDeItensReservados;}
	public void setQuantidadeDeItensReservados(int quantidadeDeItensReservados) {this.quantidadeDeItensReservados = quantidadeDeItensReservados;}

	public int getId() {return id;}
	public void setId() {
		Random gerador = new Random();
		this.id = gerador.nextInt(99);
		}
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public String getSobrenome() {return sobrenome;}
	public void setSobrenome(String sobrenome) {this.sobrenome = sobrenome;}
	public boolean isAlunoDePosGraduacao() {return alunoDePosGraduacao;}
	public void setAlunoDePosGraduacao(boolean alunoDePosGraduacao) {this.alunoDePosGraduacao = alunoDePosGraduacao;}
	public boolean isProfessor() {return professor;}
	public void setProfessor(boolean professor) {this.professor = professor;}
}
