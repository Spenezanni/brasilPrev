package br.com.brasilPrev.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;


import br.com.brasilPrev.modelo.Usuario;
import br.com.brasilPrev.repository.UsuarioRepository;

@WebMvcTest
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void criarPersistenciaDados() {
		Usuario usuario = new Usuario("Sebastiao", "123", "sebastiao@teste.com");
		this.usuarioRepository.save(usuario);
		assertThat(usuario.getId_usuario()).isNotNull();
		assertThat(usuario.getNome_usuario()).isEqualTo("Sebastiao");
		assertThat(usuario.getSenha_usuario()).isEqualTo("123");
		assertThat(usuario.getDs_email()).isEqualTo("sebastiao@teste.com");
		 
	}

}
