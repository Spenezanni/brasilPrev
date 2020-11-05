/*
 * package br.com.brasilPrev.security;
 * 
 * import java.io.IOException; import java.util.Date;
 * 
 * import javax.servlet.FilterChain; import javax.servlet.ServletException;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * 
 * import org.springframework.security.authentication.AuthenticationManager;
 * import org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.Authentication; import
 * org.springframework.security.core.AuthenticationException; import
 * org.springframework.security.web.authentication.
 * UsernamePasswordAuthenticationFilter;
 * 
 * import com.fasterxml.jackson.databind.ObjectMapper;
 * 
 * import br.com.brasilPrev.modelo.Usuario; import io.jsonwebtoken.Jwts;
 * 
 * public class JWTAuthenticationFilter extends
 * UsernamePasswordAuthenticationFilter {
 * 
 * private AuthenticationManager authenticationManager;
 * 
 * public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
 * this.authenticationManager = authenticationManager; }
 * 
 * @Override public Authentication attemptAuthentication(HttpServletRequest
 * request, HttpServletResponse response) throws AuthenticationException { try {
 * Usuario usuario = new ObjectMapper().readValue(request.getInputStream(),
 * Usuario.class); return this.authenticationManager .authenticate(new
 * UsernamePasswordAuthenticationToken(usuario.getNomeUsuario(),
 * usuario.getSenhaUsuario())); } catch (IOException e) { throw new
 * RuntimeException(e); } }
 * 
 * @Override protected void successfulAuthentication(HttpServletRequest request,
 * HttpServletResponse response, FilterChain chain, Authentication authResult)
 * throws IOException, ServletException { String username =
 * ((org.springframework.security.core.userdetails.User)
 * authResult.getPrincipal()).getUsername(); String token = Jwts .builder()
 * .setSubject(username) .setExpiration(new Date(System.currentTimeMillis() +
 * SecurityConstants.EXPIRATION_TIME))
 * .signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, SecurityConstants.SECRET)
 * .compact(); response.addHeader(SecurityConstants.HEADER_STRING,
 * SecurityConstants.TOKEN_PREFIX + token); }
 * 
 * }
 */