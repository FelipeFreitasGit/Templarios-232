package com.loja.handler;

public class UsuarioRelacionadoNaoExiste extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UsuarioRelacionadoNaoExiste(String mensagem) {
		super(mensagem);
	}
	
	public UsuarioRelacionadoNaoExiste(Throwable causa) {
		super(causa);
	}
}
