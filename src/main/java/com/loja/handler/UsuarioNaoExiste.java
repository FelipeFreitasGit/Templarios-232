package com.loja.handler;

public class UsuarioNaoExiste extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UsuarioNaoExiste(String mensagem) {
		super(mensagem);
	}
	
	public UsuarioNaoExiste(Throwable causa) {
		super(causa);
	}
}
