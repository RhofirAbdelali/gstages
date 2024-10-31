package miage.abdelali.ari.Config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
			.cors(cors -> cors.configurationSource(corsConfigurationSource()))
			.csrf((csrf) -> csrf.disable())
			.authorizeHttpRequests((authz) -> authz
					.requestMatchers("/auth/login", "/logout").permitAll()
					.requestMatchers("/students/**").hasRole("SUPERVISOR")
					.requestMatchers("/stages").hasAnyRole("USER", "ENTREPRISE", "SUPERVISOR")
					.requestMatchers("/stages/id/**").hasAnyRole("USER", "ENTREPRISE", "SUPERVISOR")
					.requestMatchers("/stages/name/**").hasAnyRole("USER", "ENTREPRISE", "SUPERVISOR")
					.requestMatchers("/stages/addstage").hasAnyRole("ENTREPRISE", "SUPERVISOR")
					.requestMatchers("/stages/update/**").hasAnyRole("ENTREPRISE", "SUPERVISOR")
					.requestMatchers("/stages/delete/**").hasAnyRole("ENTREPRISE", "SUPERVISOR")
					.anyRequest().authenticated())
				  //.httpBasic((httpBasic) -> {})
			.logout((logout) -> logout.logoutUrl("/logout")
			.logoutSuccessUrl("/login?logout=true").permitAll())
			.sessionManagement((session) -> session
			.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

		return http.build();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
		configuration.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);
		return authenticationManagerBuilder.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails supervisor = User.withUsername("supervisor").password("{noop}password").roles("SUPERVISOR").build();
		UserDetails entreprise = User.withUsername("entreprise").password("{noop}password").roles("ENTREPRISE").build();
		UserDetails user = User.withUsername("user").password("{noop}password").roles("USER").build();
		return new InMemoryUserDetailsManager(user, supervisor, entreprise);
	}

}