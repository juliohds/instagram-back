package br.com.project.instagram.resource;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.project.instagram.model.Usuario;
import br.com.project.instagram.repository.PostagemRepository;
import br.com.project.instagram.repository.UsuarioRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioRepository ur;
    @Autowired
    private PostagemRepository pr;
    
    private static final Gson gson = new Gson();
    private static final JSONObject obj = new JSONObject();
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Usuario> listar(){
		Iterable<Usuario> listaUsuario = ur.findAll();
		return listaUsuario;
	}
	
	@GetMapping(value="/{id}/perfil", produces = MediaType.APPLICATION_JSON_VALUE)
	public String carregarPerfilUsuario(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
		 
	    //return ResponseEntity.ok(gson.toJson("This is a String"));
		obj.put("usuario", ur.findWhereId(id));
		obj.put("postagem", pr.findAllWhereUserId(id));
		
		return gson.toJson(obj);
	
	}
		
	
	@PostMapping()
	public @ResponseBody Usuario salvar(@RequestBody Usuario usuario) throws Exception {
		try {
			ur.save(usuario);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return usuario;
	}
	
}
