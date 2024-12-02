package com.es.jwtSecurityKotlin.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

// esto siempre igual
@Configuration
@EnableWebSecurity // esta anotación habilita la seguridad web en la aplicación
class SecurityConfig {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { csrf -> csrf.disable() } // para pruebas de entornos de desarrollo cross-site Forgery
            .authorizeHttpRequests { auth ->
                auth

                    .requestMatchers("/usuarios/login/**").permitAll() // la ruta de login
                    .requestMatchers("/rutas_publicas/**").permitAll() // los recursos públicos
                    .requestMatchers("/secretos_extra_confidenciales/recurso1").authenticated()
                    .requestMatchers("/rutas_extra_confidenciales/ficha2**").permitAll()
                    .requestMatchers(HttpMethod.DELETE, "/rutas_protegidas/recursos/{id}").hasRole("ADMIN")

                    .anyRequest().authenticated() // cualquier otra petición requiere autenticación
            }
            .sessionManagement { session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) } // no se va a manejar sesiones
            .httpBasic(Customizer.withDefaults()) // autenticación básica
        return http.build()
    }


    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }


}