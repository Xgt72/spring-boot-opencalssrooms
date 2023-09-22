package com.springboot.security.config;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
  private JwtAuthenticationFilter jwtAuthFilter;
  private AuthenticationProvider authenticationProvider;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf((csrf) -> csrf.disable())
        .authorizeHttpRequests(
            (authorizeHttpRequests) -> authorizeHttpRequests.requestMatchers("/api/v1/auth/**").permitAll()
                .anyRequest().authenticated())
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    // .permitAll()
    // .anyRequest()
    // .authenticated()
    // .and()
    // .sessionManagement()
    // .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    // .and()
    // .authenticationProvider(authenticationProvider)
    // .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

    // http
    // .csrf()
    // .disable()
    // .authorizeHttpRequests()
    // .requestMatchers("/api/v1/auth/**")
    // .permitAll()
    // .anyRequest()
    // .authenticated()
    // .and()
    // .sessionManagement()
    // .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    // .and()
    // .authenticationProvider(authenticationProvider)
    // .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }
}
