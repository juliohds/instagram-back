package br.com.project.instagram.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Postagem {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long  id;
	
	private String img;
	
	@OneToMany
	private List<Comentario> comentario;
	
	@OneToMany
	private List<Curtida> curtida;
	
	@ManyToOne
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long  id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public List<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}

	public List<Curtida> getCurtida() {
		return curtida;
	}

	public void setCurtida(List<Curtida> curtida) {
		this.curtida = curtida;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
