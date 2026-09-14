package com.springedumanager.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfig {



    // Usuarios del sistema
    @Bean
    public InMemoryUserDetailsManager usuarios() {


        return new InMemoryUserDetailsManager(

                User.withUsername("admin")
                        .password("{noop}1234")
                        .roles("ADMIN")
                        .build(),


                User.withUsername("user")
                        .password("{noop}1234")
                        .roles("USER")
                        .build()

        );

    }



    // Configuración de seguridad
    @Bean
    public SecurityFilterChain seguridad(HttpSecurity http) throws Exception {


        http

        // Permite enviar formularios sin token CSRF
        .csrf(csrf -> csrf.disable())


        .authorizeHttpRequests(auth -> auth


                // Páginas visibles para ADMIN y USER
                .requestMatchers(
                        "/cursos",
                        "/estudiantes"
                )
                .hasAnyRole("ADMIN", "USER")



                // Guardar información solo ADMIN
                .requestMatchers(
                        "/guardarCurso",
                        "/guardarEstudiante"
                )
                .hasRole("ADMIN")



                // Todo lo demás requiere login
                .anyRequest()
                .authenticated()

        )


        // Login generado por Spring
        .formLogin(login -> login
                .permitAll()
        )


        // Cerrar sesión
        .logout(logout -> logout
                .logoutSuccessUrl("/cursos")
                .permitAll()
        );



        return http.build();

    }


}