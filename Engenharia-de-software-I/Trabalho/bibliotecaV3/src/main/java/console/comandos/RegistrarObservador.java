package console.comandos;

import java.util.List;

import biblioteca.Biblioteca;
import biblioteca.Dados;
import biblioteca.livro.Livro;
import biblioteca.usuario.IUsuario;
import biblioteca.usuario.tipo.Professor;
import console.Comando;

public class RegistrarObservador implements Comando { // EX: "obs
	public void executar(Dados dados, IUsuario usuario, List<Livro> livros, Livro livro) {
		Biblioteca.registerObserver(livro, usuario);
	}
}
