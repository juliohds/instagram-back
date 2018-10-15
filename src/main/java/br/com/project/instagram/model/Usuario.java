package br.com.project.instagram.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String login;
	
	private String statusUsuario;
	
	private String Seguidores;
	
	private String Seguindo;
	
	private String img;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getStatusUsuario() {
		return statusUsuario;
	}

	public void setStatusUsuario(String statusUsuario) {
		this.statusUsuario = statusUsuario;
	}

	public String getSeguidores() {
		return Seguidores;
	}

	public void setSeguidores(String seguidores) {
		Seguidores = seguidores;
	}

	public String getSeguindo() {
		return Seguindo;
	}

	public void setSeguindo(String seguindo) {
		Seguindo = seguindo;
	}
	
	
}
