package br.com.project.instagram.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.instagram.model.Curtida;
import br.com.project.instagram.model.Postagem;
import br.com.project.instagram.repository.CurtidaRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/curtida")
public class CurtidaResource {
	
	@Autowired
	private CurtidaRepository cr;
		
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Curtida> listar(){
		Iterable<Curtida> curtidas = cr.findAll();
		return curtidas;
	}
	
	@PostMapping(value="/{id}", produces="application/json")
	public @ResponseBody Curtida curtir(@PathVariable("id") Long id, @RequestBody Curtida curtida) {
		Postagem postagem = new Postagem();
		postagem.setId(id);
		curtida.setPostagem(postagem);
		cr.save(curtida);
		return curtida;
	}
}
