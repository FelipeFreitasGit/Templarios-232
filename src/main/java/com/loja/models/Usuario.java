package com.loja.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonInclude(Include.NON_NULL)
	@Column(unique=true, nullable=false)
	@NotNull(message = "Numero de cadastro do usuário é obrigatório")
	private Long numCadMemb;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "Nome do usuário é obrigatório")
    private String nome;
	
	@JsonInclude(Include.NON_NULL)
    private String profissao;
	
	@JsonInclude(Include.NON_NULL)
    private String cpf;
	
	@JsonInclude(Include.NON_NULL)
    private String rg;
	
	@JsonInclude(Include.NON_NULL)
    private String endResidencial;
	
	@JsonInclude(Include.NON_NULL)
    private String cidade;
	
	@JsonInclude(Include.NON_NULL)
    private String estado;
	
	@JsonInclude(Include.NON_NULL)
    private String bairro;
	
	@JsonInclude(Include.NON_NULL)
    private String cep;
	
	@JsonInclude(Include.NON_NULL)
    private String telResi;
	
	@JsonInclude(Include.NON_NULL)
    private String telComer;
	
	@JsonInclude(Include.NON_NULL)
    private String telCel;
	
	@JsonInclude(Include.NON_NULL)
    private String conjuge;
	
	@JsonInclude(Include.NON_NULL)
    private String telConju;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "Primeiro e-mail do usuário é obrigatório")
    private String email1;
	
	@JsonInclude(Include.NON_NULL)
    private String email2;
	
	@JsonInclude(Include.NON_NULL)
	private String nivel;
    
	@JsonInclude(Include.NON_NULL)
    @OneToMany(mappedBy = "usuario")
    private List<Aniversariante> aniversariantes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumCadMemb() {
		return numCadMemb;
	}

	public void setNumCadMemb(Long numCadMemb) {
		this.numCadMemb = numCadMemb;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndResidencial() {
		return endResidencial;
	}

	public void setEndResidencial(String endResidencial) {
		this.endResidencial = endResidencial;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelResi() {
		return telResi;
	}

	public void setTelResi(String telResi) {
		this.telResi = telResi;
	}

	public String getTelComer() {
		return telComer;
	}

	public void setTelComer(String telComer) {
		this.telComer = telComer;
	}

	public String getTelCel() {
		return telCel;
	}

	public void setTelCel(String telCel) {
		this.telCel = telCel;
	}

	public String getConjuge() {
		return conjuge;
	}

	public void setConjuge(String conjuge) {
		this.conjuge = conjuge;
	}

	public String getTelConju() {
		return telConju;
	}

	public void setTelConju(String telConju) {
		this.telConju = telConju;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public List<Aniversariante> getAniversariantes() {
		return aniversariantes;
	}

	public void setAniversariantes(List<Aniversariante> aniversariantes) {
		this.aniversariantes = aniversariantes;
	}
	
	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
