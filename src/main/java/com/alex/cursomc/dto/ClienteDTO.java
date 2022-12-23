package com.alex.cursomc.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.alex.cursomc.domain.Cliente;

public class ClienteDTO {

	private Integer id;
	
	@NotEmpty(message = "Preenchimento Obrigatorio")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 80 Caracteres")
	private String nome;
	
	@NotEmpty(message = "Preenchimento Obrigatorio")
	@Email(message = "Email Invalido")
	private String email;
	
	private String senha;
	
	public ClienteDTO() {
	}

	public ClienteDTO(Cliente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	


}
