package com.CompraVenda.cv.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Fornecedores implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	private String razao_social;
	
	@NotEmpty
	@Column(name="cnpj", unique=true)
	private String cnpj;
	
	@NotEmpty
	@Column(name="endereco")
	private String endereco;
	
	@NotEmpty
	@Column(name="bairro")
	private String bairro;
	
	@NotEmpty
	@Column(name="cidade")
	private String cidade;
	
	@NotEmpty
	@Column(name="uf")
	private String uf;
	
	@NotEmpty
	@Column(name="cep")
	private String cep;
	
	@NotEmpty
	@Column(name="telefone")
	private String telefone;
	
	@NotEmpty
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy = "fornecedores", cascade = CascadeType.REMOVE)
	private List<Compras> compras;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRazao_social() {
		return razao_social;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
