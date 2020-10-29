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
	private Long idUsuario;

	@Column(name = "NOME_USUARIO")
	private String nomeUsuario;
	
	@Column(name = "SENHA_USUARIO")
	private String senhaUsuario;

	@Column(name = "DS_EMAIL")
	private String dsEmail;
	
	@Column(name="ADMIN")
	private boolean admin;
	
	public Usuario() {
		
	}

	public Usuario(String nomeUsuario, String senhaUsuario, String dsEmail, boolean admin) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.senhaUsuario = senhaUsuario;
		this.dsEmail = dsEmail;
		this.admin = admin;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
}


