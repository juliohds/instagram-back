package br.com.project.instagram.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.project.instagram.model.Curtida;

@Repository
public interface CurtidaRepository extends CrudRepository<Curtida, Long> {

}
