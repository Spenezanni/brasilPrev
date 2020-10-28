package br.com.brasilPrev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brasilPrev.modelo.Usuario;
import br.com.brasilPrev.repository.UsuarioRepository;
import br.com.brasilPrev.service.UsuarioService;
import br.com.brasilPrev.error.ResourceNotFoundException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuariorepository;

	@Override
	public Usuario salvar(Usuario usuario) {
		return usuariorepository.save(usuario);
	}

	@Override
	public List<Usuario> buscarListaDeUsuarios() {
		return usuariorepository.findAll();
	}

	@Override
	public void verificarIdUsuario(Long id) {
		if (this.usuariorepository.findById(id) == null) {
			throw new ResourceNotFoundException("Usuário não encontrado" + " " + id);
		}

	}

	@Override
	public void deletarUsuario(Long id) {
		this.usuariorepository.deleteById(id);
	}

}
