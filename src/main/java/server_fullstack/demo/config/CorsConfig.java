package server_fullstack.demo.config;

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
                // Permet tous les endpoints
                registry.addMapping("/**")
                        // Autorise uniquement les requêtes venant de minikube:30000
                        .allowedOrigins("http://192.168.58.2:30000")
                        // Méthodes autorisées
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        // Autorise tous les en-têtes
                        .allowedHeaders("*")
                        // Autorise les cookies/credentials
                        .allowCredentials(true);
            }
        };
    }
}
