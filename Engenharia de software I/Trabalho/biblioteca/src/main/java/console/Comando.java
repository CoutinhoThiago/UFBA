package console;

import biblioteca.item.Livro;
import biblioteca.usuario.Usuario;

public interface Comando {
	public void executar(Usuario usuario, Livro livro);
}
