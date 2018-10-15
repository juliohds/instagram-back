package br.com.project.instagram.resource;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.instagram.model.Postagem;
import br.com.project.instagram.repository.PostagemRepository;
import br.com.project.instagram.repository.UsuarioRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/postagem")
public class PostagemResource {
	
	@Autowired
	private PostagemRepository pr;
	@Autowired
	private UsuarioRepository ur;

	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Postagem> listar(){
		Iterable<Postagem> lista = pr.findAll();
		return lista;
	}
	
	@PostMapping()
	public @ResponseBody Postagem salvar(@RequestAttribute("usuario_id") String id, @RequestBody Postagem postagem, HttpServletRequest request) throws Exception {
		try {
			try {
//todo salvar usuario que postou img
				System.out.println(id);
//				Long id = Long.parseLong();
//				Usuario user = new Usuario();
//				user = ur.findWhereId(id);
//				
//				postagem.setUsuario(user);
			} catch (Exception e) {
				throw new Exception(e);
			}
			pr.save(postagem);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return postagem;
	}
	
}
