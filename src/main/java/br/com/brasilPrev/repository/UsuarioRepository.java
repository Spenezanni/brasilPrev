package br.com.brasilPrev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brasilPrev.modelo.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByNome_usuario(String nome_usuario);
	
}
