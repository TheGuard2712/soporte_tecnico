package com.example.soporte.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info()
                .title("API Soporte Técnico")
                .description("Spring Boot 3 + MySQL + JPA + OpenAPI (Java 21)")
                .version("v1.0")
                .contact(new Contact().name("Equipo Backend").email("equipo@example.com")));
    }
}
