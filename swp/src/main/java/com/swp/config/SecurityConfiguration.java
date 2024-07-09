package com.swp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.swp.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration implements WebMvcConfigurer {
	private  UserService userService;
    

    public SecurityConfiguration(UserService userService) {
        this.userService = userService;
        
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    @Bean @Lazy
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        
        return auth;
    }

    /*@Bean @Lazy
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/**").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }*/
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest()
        .permitAll())
        //.authenticated())
        //.httpBasic(withDefaults())
        //.formLogin(withDefaults()) 
        .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    @Bean
	public InMemoryUserDetailsManager userDetailsService() {
	    UserDetails user = User.withUsername("user")
	      .password(encoder().encode("userPass"))
	      .roles("USER")
	      .build();
	    return new InMemoryUserDetailsManager(user);
	}
	 
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") 
                .allowedMethods("*")
                .allowCredentials(true)
                .allowedHeaders("*");
    }

}
