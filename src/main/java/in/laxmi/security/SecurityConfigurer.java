package in.laxmi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthorityAuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import in.laxmi.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer {
	/*
	 * @Bean public InMemoryUserDetailsManager configureUsers() { UserDetails
	 * adminUser =
	 * User.withDefaultPasswordEncoder().username("lakshmi").password("laxmi@123")
	 * .authorities("ADMIN").build(); UserDetails normalUser =
	 * User.withDefaultPasswordEncoder().username("rani").password("rani@123")
	 * .authorities("USER").build(); return new
	 * InMemoryUserDetailsManager(adminUser, normalUser); }
	 */
	@Autowired
	private MyUserDetailsService userServiceDtls;
	@Autowired
    public void ConfigureUsers(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userServiceDtls)
    	.passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((req) -> req.antMatchers("/contact").permitAll().anyRequest().authenticated())
				.formLogin();

		return http.build();
	}
}
