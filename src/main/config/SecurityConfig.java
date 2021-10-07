package main.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	// Configure users
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select login, password, enabled from user where login=?")
			.authoritiesByUsernameQuery("select login, role from role whre login=?");
			
			// below is how to hardcode users
//			.inMemoryAuthentication()
//			.withUser("Ibby").password(passwordEncoder().encode("password")).roles("ADMIN", "EMPLOYEE")
//			.and()
//			.withUser("Eric").password(passwordEncoder().encode("employee")).roles("EMPLOYEE")
//			.and()
//			.withUser("Mike").password(passwordEncoder().encode("client")).roles("CLIENT");
	}
	
	// Configuring access to different parts of application
	// In this case main page and login accessible to all USERS
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/", "/login")
			.permitAll()
		.antMatchers("/addTour", "/editTour")
			.hasAnyRole("ADMIN", "EMPLOYEE")
		.antMatchers("/deleteTour")
			.hasAnyRole("ADMIN")
		.and()
			.formLogin()
			.defaultSuccessUrl("/")
			.permitAll()
		.and()
			.logout()
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true)
			.permitAll();
		// to have a custom forbidden page 
//		.and()
//			.exceptionHandling().accessDeniedPage("/forbidden");
	}
	
	
	
	
}
