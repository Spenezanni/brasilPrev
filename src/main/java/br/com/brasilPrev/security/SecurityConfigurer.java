package br.com.brasilPrev.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

import br.com.brasilPrev.service.CustomUserDetailService;
import br.com.brasilPrev.security.SecurityConstants;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailService customUserDetailService;

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()).and()
		.csrf().disable().authorizeRequests()
		//.antMatchers(HttpMethod.GET, SecurityConstants.SIGN_UP_URL).permitAll()
		.antMatchers("/*/login/**").permitAll()
		.antMatchers("/*/protected/**").hasRole("USER") 
		.antMatchers("/*/admin/**").permitAll();//.hasRole("ADMIN")
		/*.and()*/
		/*.addFilter(new JWTAuthenticationFilter(authenticationManager()))
		.addFilter(new JWTAuthorizationFilter(authenticationManager(),customUserDetailService ));*/
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
	}

	
	
	/*
	 * @Override public void configure(HttpSecurity http) throws Exception {
	 * http.cors().configurationSource(request -> new
	 * CorsConfiguration().applyPermitDefaultValues())
	 * .and().csrf().disable().authorizeRequests().anyRequest().authenticated() //
	 * .antMatchers("/**").permitAll() .anyRequest( .and().httpBasic(); // .and()
	 * //.addFilter(new
	 * 
	 * http.headers().frameOptions().sameOrigin();
	 * 
	 * }
	 */
	/*
	 * public void configureGlobal1(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().withUser("luiz").password("123").roles("USER").
	 * and().withUser("admin") .password("123").roles("USER", "ADMIN");
	 * 
	 * }
	 */

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.userDetailsService(customUserDetailService).passwordEncoder(new
	 * BCryptPasswordEncoder()); }
	 */

	/*
	 * public void configureGlobal(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().withUser("Luiz").password("123").roles("USER").
	 * and().withUser("Land") .password("123").roles("USER", "ADMIN"); }
	 */
}
