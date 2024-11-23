package ma.projet.graph;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configuration des ressources statiques (CSS, JS, images, etc.).
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");

        registry.addResourceHandler("/public/**")
                .addResourceLocations("classpath:/public/");
    }

    /**
     * Redirection des URL vers des vues spécifiques.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Redirige les requêtes vers "/" vers "index.html"
        registry.addViewController("/").setViewName("forward:/index.html");
    }

    /**
     * Configuration CORS pour autoriser les requêtes venant d'origines différentes.
     *
     * @return CorsFilter
     */
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*"); // Utilisez addAllowedOriginPattern pour plus de sécurité
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
