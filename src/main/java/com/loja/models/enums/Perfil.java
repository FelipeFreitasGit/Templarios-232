package com.loja.models.enums;

public enum Perfil {
	
	ADMINISTRADOR(1, "ROLE_ADMINISTRADOR"),
	MESTRE(2, "ROLE_MESTRE"),
	COMPANHEIRO(3, "ROLE_MESTRE"),
	APRENDIZ(4, "ROLE_APRENDIZ"),
	ACACIAS(5, "ROLE_ACACIAS");
	
	private int cod;
	private String descricao;
	
	private Perfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static Perfil toEnum(Integer cod) {
			
			if (cod == null) {
				return null;
			}
			
			for (Perfil x : Perfil.values()) {
				if (cod.equals(x.getCod())) {
					return x;
				}
			}
			
			throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
