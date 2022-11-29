package biblioteca.usuario.tipo;

import java.util.List;

import biblioteca.Emprestimo;
import biblioteca.ItenObservado;
import biblioteca.Reserva;
import biblioteca.item.Livro;
import biblioteca.usuario.criador.CriadorContasAlunoDePosGraduacao;
import biblioteca.usuario.interfaces.ICriadorContas;
import biblioteca.usuario.interfaces.IInscricao;
import biblioteca.usuario.interfaces.Observer;

public class AlunoDePosGraduacao implements IInscricao, Observer {
	private int codigo;
	private String nome;
	
	private int tempoDeImprestimo;
	private int quantidadeDeItensReservados;
	
	private boolean alunoDePosGraduacao = true;
	
	private boolean emAtraso;
	
	public List<Reserva> listaDeReservas;
	public List<Emprestimo> listaDeEmprestimos;
	public List<ItenObservado> listaDeItensObservados;
	
	public void update(Livro livro) {
		// TODO Auto-generated method stub
		
	}
	
	public AlunoDePosGraduacao(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}	
	
	public String getNome() {return nome;}
	public int getCodigo() {return codigo;}
	public ICriadorContas obterCriadorContas() {return new CriadorContasAlunoDePosGraduacao();}
	
	public int getTempoDeImprestimo() {return tempoDeImprestimo;}
	public void setTempoDeImprestimo(int tempoDeImprestimo) {this.tempoDeImprestimo = tempoDeImprestimo;}
	public int getQuantidadeDeItensReservados() {return quantidadeDeItensReservados;}
	public void setQuantidadeDeItensReservados(int quantidadeDeItensReservados) {this.quantidadeDeItensReservados = quantidadeDeItensReservados;}
}