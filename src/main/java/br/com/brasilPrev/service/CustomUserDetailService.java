package br.com.brasilPrev.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.brasilPrev.modelo.Usuario;
import br.com.brasilPrev.repository.UsuarioRepository;

@Component
@Transactional
public class CustomUserDetailService implements UserDetailsService {

	private final UsuarioRepository usuarioRepository;

	@Autowired
	public CustomUserDetailService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = Optional.ofNullable(this.usuarioRepository.findByNome_usuario(username))
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
		List<GrantedAuthority> authorityAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
		List<GrantedAuthority> authorityUser = AuthorityUtils.createAuthorityList("ROLE_USER");
		return new org.springframework.security.core.userdetails.User(usuario.getNome_usuario(),usuario.getSenha_usuario(),
				usuario.isAdmin() ? authorityAdmin : authorityUser);
	}

}
