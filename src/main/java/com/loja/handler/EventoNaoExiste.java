package com.loja.handler;

public class EventoNaoExiste extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EventoNaoExiste(String mensagem) {
		super(mensagem);
	}
	
	public EventoNaoExiste(Throwable causa) {
		super(causa);
	}
}
