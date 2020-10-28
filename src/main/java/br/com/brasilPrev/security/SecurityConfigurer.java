package br.com.brasilPrev.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests().anyRequest().authenticated()
				// .antMatchers("/**").permitAll() .anyRequest(
				.and().httpBasic(); // .and() //.addFilter(new

		http.headers().frameOptions().sameOrigin();

	}

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

	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Luiz").password("123").roles("USER").and().withUser("Land")
				.password("123").roles("USER", "ADMIN");
	}

}
