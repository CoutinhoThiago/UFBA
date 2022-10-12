package br.ufba.idp.mecanismos;

import br.ufba.idp.interfaces.IFuncionario;
import br.ufba.idp.interfaces.IMensagem;

public class MecanismoEmail implements IMensagem {
	public void enviarMensagem(IFuncionario funcionario, String mensagem){
		System.out.println("Simulando o envio de email para " + funcionario.getNome());
	}
}
