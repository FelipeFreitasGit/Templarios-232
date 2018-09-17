package com.loja.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "aniversariante")
public class Aniversariante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "A data de aniversário é obrigatório.")
	private Date dataAniversario;
	
	@JsonInclude(Include.NON_NULL)
    private String relacao;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "O nome do aniversário é obrigatório.")
    private String nomeAniversariante;
	
	@JsonInclude(Include.NON_NULL)
    private String telefoneAni;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "O email é obrigatório.")
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonInclude(Include.NON_NULL)
    private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public String getRelacao() {
		return relacao;
	}

	public void setRelacao(String relacao) {
		this.relacao = relacao;
	}

	public String getNomeAniversariante() {
		return nomeAniversariante;
	}

	public void setNomeAniversariante(String nomeAniversariante) {
		this.nomeAniversariante = nomeAniversariante;
	}

	public String getTelefoneAni() {
		return telefoneAni;
	}

	public void setTelefoneAni(String telefoneAni) {
		this.telefoneAni = telefoneAni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
