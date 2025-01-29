package com.kb.location.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI cimcopressOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API KB Location")
                        .description("API de gestion des reservations de voiture pour les KB")
                        .version("1.0")
                        .contact(new Contact()
                                .name("KB Location")
                                .email("contact@kblocation.com")))
                .addServersItem(new Server().url("/").description("Default Server URL"));
    }
} 