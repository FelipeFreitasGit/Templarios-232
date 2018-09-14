package com.loja.handler;

public class UsuarioLoginNaoExiste extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UsuarioLoginNaoExiste(String mensagem) {
		super(mensagem);
	}
	
	public UsuarioLoginNaoExiste(Throwable causa) {
		super(causa);
	}
}
