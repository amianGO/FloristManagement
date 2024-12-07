package com.florist.v1.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.florist.v1.Services.UsuarioService;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
    
    @Autowired
    private UsuarioService UsuarioService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(UsuarioService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/home","/Flower/List").permitAll() // Página principal accesible sin login
                .requestMatchers("/CreateFlowers","/CreateMakers").hasRole("ADMIN")
                .requestMatchers("/index").hasRole("ADMIN") // Solo ADMIN puede crear, editar y eliminar
                .requestMatchers("/Makers/**").hasRole("ADMIN")
                .requestMatchers("/admin/**").hasRole("ADMIN") // Solo ADMIN puede acceder
                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN") // USER o ADMIN
                .anyRequest().authenticated() // Cualquier otra ruta requiere autenticación
            )
            .formLogin(login -> login
                .loginPage("/login") // Página de login personalizada
                .permitAll()
                .defaultSuccessUrl("/index")
            )
            .logout(logout -> logout.permitAll()); // Configuración de logout

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(UsuarioService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
