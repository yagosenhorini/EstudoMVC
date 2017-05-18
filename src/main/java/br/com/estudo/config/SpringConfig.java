package br.com.estudo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

public class SpringConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AccessDeniedHandler acessoNegado;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.csrf().disable()
				.authorizeRequests()
					.antMatchers("/", "/home", "/about").permitAll()
					.antMatchers("/admin/**").hasAnyRole("ADMIN")
					.antMatchers("/user/**").hasAnyRole("USER")
					.anyRequest().authenticated()
				.and()
				.formLogin()
					.loginPage("/login")
					.permitAll()
					.and()
				.logout()
					.permitAll()
					.and()
				.exceptionHandling().accessDeniedHandler(acessoNegado);
		
	}
	
	//Criação de dois usuários (Administrador e Usuário)
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.inMemoryAuthentication()
			.withUser("user").password("password").roles("USER")
			.and()
			.withUser("user").password("password").roles("ADMIN");
	}

}
