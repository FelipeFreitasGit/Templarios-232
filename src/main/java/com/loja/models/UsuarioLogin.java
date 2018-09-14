package com.loja.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuariologin")
public class UsuarioLogin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Nivel do usuário é obrigatório")
	private String nivelLogin;
	
	@NotNull(message = "Senha do usuário é obrigatório")
	private String senha;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNivelLogin() {
		return nivelLogin;
	}
	public void setNivelLogin(String nivelLogin) {
		this.nivelLogin = nivelLogin;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
