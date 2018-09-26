package com.loja.handler;

public class EventoDataInicioMaiorQueFinal extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EventoDataInicioMaiorQueFinal(String mensagem) {
		super(mensagem);
	}
	
	public EventoDataInicioMaiorQueFinal(Throwable causa) {
		super(causa);
	}
}
