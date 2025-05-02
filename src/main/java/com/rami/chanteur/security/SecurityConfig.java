package com.rami.chanteur.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/webjars/**", "/h2-console/**").permitAll()
                .requestMatchers("/ListeChanteur").hasAnyAuthority("ADMIN", "USER", "AGENT")
                .requestMatchers("/showCreate", "/saveChanteur").hasAnyAuthority("ADMIN", "AGENT")
                .requestMatchers("/modifierChanteur", "/updateChanteur", "/supprimerChanteur").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/ListeChanteur", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            )
            .exceptionHandling(ex -> ex
                .accessDeniedPage("/accessDenied")
            )
            .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**")) // Optional for H2 console
            .headers(headers -> headers.frameOptions().disable()) // Optional for H2 console
            .build();
    }
}