package br.com.project.instagram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.project.instagram.model.Postagem;

@Repository
public interface PostagemRepository extends CrudRepository<Postagem, Long>{
	
	@Query(value= "SELECT p.* FROM postagem p INNER JOIN usuario u ON u.id = p.usuario_id", nativeQuery = true)
	public  List<Postagem> findAllWhereUserId(Long id);
	
}
