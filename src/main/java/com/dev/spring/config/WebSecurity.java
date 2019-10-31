package com.dev.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		/*authenticationMgr.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("user")
				.password(passwordEncoder.encode("123456")).roles("USER").and().withUser("admin")
				.password(passwordEncoder.encode("123456")).roles("USER", "ADMIN");*/

		authenticationMgr.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password, enabled  from users where username=?")
				.authoritiesByUsernameQuery("select username, authority from authorities where username=?")
				.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login*").permitAll().antMatchers("/**").hasAnyRole("ADMIN", "USER").and()
				.formLogin().loginPage("/login").defaultSuccessUrl("/home").failureUrl("/login?error=true").permitAll()
				.and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll().and()
				.httpBasic().and().csrf().disable();
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}