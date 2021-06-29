/**
 * 
 */
package ar.edu.unju.fi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ar.edu.unju.fi.service.imp.UsuarioDetailsServiceImp;

/**
 * @author Enzo Sandoval
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UsuarioDetailsServiceImp usuarioDetailsService;
	
	@Autowired
	AutenticacionSuccessHandler autSuccessHandler;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioDetailsService).passwordEncoder(passwordEncoder());
	}

	String[] resources = new String[] { "/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**",
			"/layout/**", "/webjars/**", "/compra" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers(resources)
			.permitAll()
			.antMatchers("/", "/home", "login","/signup", "/logout")
			.permitAll()
			.antMatchers(HttpMethod.POST,"/user/save")
			.permitAll()
			.antMatchers(HttpMethod.GET, "/products/details/**").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
			.successHandler(autSuccessHandler)
			.failureUrl("/login?error=true")
			.usernameParameter("username")
			.passwordParameter("password")				
			.and()
		.logout()
			.permitAll()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	        .logoutSuccessUrl("/login?logot").permitAll()
	        .deleteCookies("JSESSIONID");
		http.csrf().disable();    
	        
	}

}
