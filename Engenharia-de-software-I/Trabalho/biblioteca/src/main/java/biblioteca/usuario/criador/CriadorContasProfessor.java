package biblioteca.usuario.criador;

import biblioteca.usuario.Usuario;
import biblioteca.usuario.interfaces.IInscricao;
import biblioteca.usuario.interfaces.ICriadorContas;

public class CriadorContasProfessor implements ICriadorContas {
    
	public Usuario criar(IInscricao aluno)
    {
        Usuario usuario = new Usuario();

        usuario.setCodigo(aluno.getCodigo());
        usuario.setNome(aluno.getNome());
        
        usuario.setTempoDeEmprestimo(7); // 7 dias
        usuario.setQuantidadeDeItensReservados(999); // sem limite
        
        usuario.setProfessor(true);
        
        return usuario;
    }
}
