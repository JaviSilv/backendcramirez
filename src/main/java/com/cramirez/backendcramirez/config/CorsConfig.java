package com.cramirez.backendcramirez.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("https://cramirezsac.vercel.app") // Permitir solo el frontend en Vercel
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*") // Permitir todos los encabezados
                        .allowCredentials(true); // Si usas autenticación basada en cookies o headers personalizados
            }
        };
    }
}
