package com.example.CORS.CorsConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration // indica che la classe CorsConfig è una classe di configurazione
public class CorsConfig {

    @Bean //questa annotazione fa si che, il metodo sotto CorsFiltrer, dia come risultato un Bean che verrà gestito dal container (che dovrebbe essere il controller)
    public CorsFilter corsFilter() {
        // viene creata una istanza di questo oggetto che sarà una fonte di configurazione di COrs basata sulla URL
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();//viene creata una istanza della configurazione di cors.


        config.addAllowedOrigin("http://localhost:8080");// lo * indica, come per le query, che l'accesso è a tutti. sono suddivisi per URL, Header e method (consente tutte le operazioni). questo di solito non si fa, oltretutto rende inutile l'uso di CORS.
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}

