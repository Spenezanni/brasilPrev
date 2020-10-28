package br.com.brasilPrev.service;

import java.util.List;

import br.com.brasilPrev.modelo.Usuario;

public interface UsuarioService {
	
    public Usuario salvar(Usuario usuario); 
    
    public List<Usuario> buscarListaDeUsuarios();
    
    public void deletarUsuario(Long id);
    
    public void verificarIdUsuario(Long id);

}
