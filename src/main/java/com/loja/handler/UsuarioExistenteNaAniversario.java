package com.loja.handler;

public class UsuarioExistenteNaAniversario extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public UsuarioExistenteNaAniversario(String mensagem){
		super(mensagem);
	}
	
	public UsuarioExistenteNaAniversario(String mensagem, Throwable causa) {
		super(mensagem,causa);
	}

}
