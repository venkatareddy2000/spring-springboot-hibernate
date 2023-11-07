package com.spring.springboot.hibernate.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	/*
	 * @Bean public InMemoryUserDetailsManager userDetailsManager() {
	 * 
	 * UserDetails john =
	 * User.builder().username("john").password("{noop}test123").roles("Employee").
	 * build(); UserDetails mary =
	 * User.builder().username("mary").password("{noop}test123").roles("Employee",
	 * "Manager") .build(); UserDetails susan =
	 * User.builder().username("susan").password("{noop}test123") .roles("Employee",
	 * "Manager", "Admin").build(); return new InMemoryUserDetailsManager(john,
	 * mary, susan);
	 * 
	 * }
	 */
	/*
	 * @Bean public UserDetailsManager userDetailsManager(DataSource dataSource) {
	 * 
	 * return new JdbcUserDetailsManager(dataSource);
	 * 
	 * }
	 */

	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");
		return jdbcUserDetailsManager;
	}

	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	 * Exception {
	 * 
	 * http.authorizeHttpRequests(configurer -> configurer
	 * .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("Employee")
	 * .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("Employee")
	 * .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("Manager")
	 * .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("Manager")
	 * .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("Admin"));
	 * http.httpBasic(Customizer.withDefaults()); http.csrf(csrf -> csrf.disable());
	 * 
	 * return http.build(); }
	 */

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(configurer -> configurer.requestMatchers(HttpMethod.GET, "/api/employees")
				.hasRole("EMPLOYEE").requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));
		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());

		return http.build();
	}

}
