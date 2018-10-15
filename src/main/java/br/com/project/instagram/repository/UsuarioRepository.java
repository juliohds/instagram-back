package br.com.project.instagram.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.project.instagram.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query(value= "SELECT * FROM usuario c where c.id = ?", nativeQuery = true)
	public Usuario findWhereId(Long id);
	
	@Query(value="SELECT u.id, u.seguidores, u.seguindo, u.status_usuario, u.login, u.nome, u.img, p.img as 'POSTAGEM' FROM usuario u INNER JOIN postagem p ON p.usuario_id = u.id", nativeQuery=true)
	public Optional<Usuario> findPerfilById(Long id);
	
}
