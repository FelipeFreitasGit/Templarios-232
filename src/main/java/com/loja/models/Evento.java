package com.loja.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "evento")
public class Evento{
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JsonInclude(Include.NON_NULL)
    private String titulo;
    
    @JsonInclude(Include.NON_NULL)
    private String inicio;
    
    @JsonInclude(Include.NON_NULL)
    private String fim;
    
    @JsonInclude(Include.NON_NULL)
    private String descricao;
    
    @JsonInclude(Include.NON_NULL)
    private boolean status;
    
    @JsonInclude(Include.NON_NULL)
    private boolean enviarEmail;

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFim() {
		return fim;
	}

	public void setFim(String fim) {
		this.fim = fim;
	}

	public boolean isEnviarEmail() {
		return enviarEmail;
	}

	public void setEnviarEmail(boolean enviarEmail) {
		this.enviarEmail = enviarEmail;
	}
}
