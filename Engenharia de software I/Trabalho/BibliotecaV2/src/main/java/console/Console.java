package console;

import java.util.List;
import java.util.Scanner;

import biblioteca.Dados;
import biblioteca.livro.Livro;
import biblioteca.usuario.IUsuario;
import console.comandos.Comando;
import console.comandos.basicos.Devolver;
import console.comandos.basicos.PegarEmprestado;
import console.comandos.basicos.RegistrarObservador;
import console.comandos.basicos.Reservar;
import console.comandos.consultas.ConsultarLivro;
import console.comandos.consultas.ConsultarNotificacoes;
import console.comandos.consultas.ConsultarUsuario;

public class Console {
	
	public static void selecionarFuncionalidade() {
		Dados dados = new Dados();
		List<IUsuario> usuarios = dados.getListaDeUsuarios();
		List<Livro> livros = dados.getListaDeLivros();
		
		
		System.out.println("Bom dia, O que o senhor deseja fazer ?"); // 
		System.out.println("Digite: " + "emp" + ", " + 
				"o código do usuario e" + 
				" o código do livro" + 
				" para realizar o emprestimo de um livro");
		System.out.println("Digite: " + "dev" + " para realizar a devolução de um livro");
		System.out.println("Digite: " + "res" + " para realizar a reserva de um livro");
		System.out.println("Digite: " + "obs" + " para se registrar como observador de um livro");
		System.out.println("Digite: " + "liv" + " para realizar a consulta de um livro pelo seu código");
		System.out.println("Digite: " + "usu" + " para realizar o consulta dos emprestimos de um usuário");
		System.out.println("Digite: " + "ntf" + " para checar a quantidade de vezes que um professor foi notificado");
		System.out.println("Digite: " + "sai" + " para sair do sistema");
		Scanner ler = new Scanner(System.in);
		
		while (true) { 
			String[] entrada = ler.nextLine().split(" "); 
				String operacao= entrada[0];
			
			if (operacao.equals("sai")) { System.out.println("adeuxxxxxx"); break;} //Cabo daciolo
			
		
			else if (operacao.equals("emp") || operacao.equals("dev") || operacao.equals("res") || operacao.equals("obs")) {
				int codigoDoUsuario = Integer.parseInt(entrada[1]);	//System.out.println(codigoDoUsuario);
				int codigoDoLivro = Integer.parseInt(entrada[2]);	//System.out.println(codigoDoLivro);
				IUsuario usuario = Buscar.buscarUsuario(usuarios, codigoDoUsuario);
				Livro livro = Buscar.buscarLivro(livros, codigoDoLivro);
				List<Livro> listaDeLivro = Buscar.buscarExemplares(livros, codigoDoLivro);
			
				if (operacao.equals("emp")) {
					Comando comando = new PegarEmprestado();
						comando.executar(dados, usuario, livro, livros);
				}
				else if (operacao.equals("dev")) {
					Comando comando = new Devolver();
						comando.executar(dados, usuario, livro, livros);
				}
				else if (operacao.equals("res")) {
					Comando comando = new Reservar();
						comando.executar(dados, usuario, livro, livros);
				}
				else if (operacao.equals("obs")) {
					Comando comando = new RegistrarObservador();
						comando.executar(dados, usuario, livro, livros);
				}	
			}
			else if (operacao.equals("liv")) {
				int codigoDoLivro = Integer.parseInt(entrada[1]);	//System.out.println(codigoDoLivro);
				Livro livro = Buscar.buscarLivro(livros, codigoDoLivro);
				List<Livro> exemplares = Buscar.buscarExemplares(livros, codigoDoLivro);
				Comando comando = new ConsultarLivro();
					comando.executar(dados, null, livro, exemplares);
			}
			else if (operacao.equals("usu")) {
				int codigoDoUsuario = Integer.parseInt(entrada[1]);	//System.out.println(codigoDoUsuario);
				IUsuario usuario = Buscar.buscarUsuario(usuarios, codigoDoUsuario);
				Comando comando = new ConsultarUsuario();
					comando.executar(dados, usuario, null, livros);
			}
			else if (operacao.equals("ntf")) {
				int codigoDoUsuario = Integer.parseInt(entrada[1]);	//System.out.println(codigoDoUsuario);
				IUsuario usuario = Buscar.buscarUsuario(usuarios, codigoDoUsuario);
				Comando comando = new ConsultarNotificacoes();
					comando.executar(dados, usuario, null, livros);
			}	

	
			else {
				System.out.println(operacao + " não é um comando valido");
				System.out.println("Por favor digite um comando valido ou sai para encerrar o programa");
			}
		}
	}
}
