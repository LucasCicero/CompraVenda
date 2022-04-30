package com.CompraVenda.cv.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
	auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());	
	//.auth.userDetailsService(userDetailsService);
	}

protected void configure(HttpSecurity http) throws Exception{
	
	http.csrf().disable().authorizeRequests()
	/*
	
	.antMatchers("/funcionarios**").hasRole("ADMIN")
	.antMatchers("/funcionarios**").hasRole("ADMIN")
	.antMatchers("/clientes**").hasRole("VENDEDOR")
	.antMatchers("/vendas**").hasRole("VENDEDOR")
	.antMatchers("/produtos").hasRole("COMPRADOR")
	.antMatchers("/compras**").hasRole("COMPRADOR")
	.antMatchers("/fornecedor**").hasRole("COMPRADOR")
	.antMatchers("/categorias**").hasRole("COMPRADOR")
	.and().formLogin().loginPage("/login").permitAll()
	.defaultSuccessUrl("/default")
	.and().logout().permitAll()
	
	*/
	.antMatchers("/resources/**").permitAll()
	.antMatchers("/static/**").permitAll()
	.antMatchers("/css**").permitAll()
	.antMatchers("/clientes**").hasRole("VENDEDOR")
	.antMatchers("/vendas**").hasRole("VENDEDOR")
	.antMatchers("/produtos").hasRole("COMPRADOR")
	.antMatchers("/compras**").hasRole("COMPRADOR")
	.antMatchers("/fornecedor**").hasRole("COMPRADOR")
	.antMatchers("/categorias**").hasRole("COMPRADOR")
	.antMatchers(HttpMethod.POST,"/funcionarios").hasRole("ADMIN")
	.antMatchers(HttpMethod.GET,"/funcionarios").hasRole("ADMIN")
	.anyRequest().authenticated() 
	.and().formLogin().loginPage("/").permitAll()
	.defaultSuccessUrl("/default")
	.and().logout().permitAll();
}
  @Override
  public void configure(WebSecurity web) throws Exception{
	  web.ignoring().antMatchers("/resources/**","/static/**","/bootstrap/**","/css**/","/js**/");
	//  registry.addResourceHandler("/resources/**").addResourceLocations("/resources/css", "/resources/images","resources/js");
  }
  //@Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/resources/**").addResourceLocations("/resources/css", "/resources/images","resources/js");
  }

}

