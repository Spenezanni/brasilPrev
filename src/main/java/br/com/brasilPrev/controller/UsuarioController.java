package br.com.brasilPrev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brasilPrev.modelo.Usuario;
import br.com.brasilPrev.service.UsuarioService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "brasilPrev/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@PostMapping
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> salvarUsuario(@RequestBody Usuario usuario) {
		return new ResponseEntity<>(usuarioService.salvar(usuario), HttpStatus.CREATED);
	}
	
	@GetMapping 
	public List<Usuario> listTodosUsuarios() {
		return this.usuarioService.buscarListaDeUsuarios();
	}
	
	@DeleteMapping(path = "/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Usuario> deleleUsuario(@PathVariable Long id) {
		this.usuarioService.verificarIdUsuario(id);
		this.usuarioService.deletarUsuario(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
