package br.com.brasilPrev.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Long id_usuario;

	@Column(name = "NOME_USUARIO")
	private String nome_usuario;
	
	@Column(name = "SENHA_USUARIO")
	private String senha_usuario;

	@Column(name = "DS_EMAIL")
	private String ds_email;
	
	public Usuario() {
		
	}

	public Usuario(String nome_usuario, String senha_usuario, String ds_email) {
		this.nome_usuario = nome_usuario;
		this.senha_usuario = senha_usuario;
		this.ds_email = ds_email;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public String getSenha_usuario() {
		return senha_usuario;
	}

	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}

	public String getDs_email() {
		return ds_email;
	}

	public void setDs_email(String ds_email) {
		this.ds_email = ds_email;
	}
	
	
	
}


