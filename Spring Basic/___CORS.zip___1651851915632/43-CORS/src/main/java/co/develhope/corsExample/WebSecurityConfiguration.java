package co.develhope.corsExample;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity //abilita la configurazione della sicurezza web di Spring.
public class WebSecurityConfiguration
        extends WebSecurityConfigurerAdapter { //Questa classe è estesa per fornire la configurazione della sicurezza.

    @Bean
    public CorsConfigurationSource corsConfigurationSource() { //Questo metodo dichiara un bean di configurazione CORS. Il bean viene utilizzato per definire le regole di CORS per l'applicazione. Viene creato un oggetto

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(); //Viene creato un oggetto UrlBasedCorsConfigurationSource che mappa i percorsi delle richieste con le configurazioni CORS associate.
        CorsConfiguration defaultCors = new CorsConfiguration().applyPermitDefaultValues();
        defaultCors.addAllowedOrigin("http://localhost:5510"); //il metodo addAlowedOrigin aggiunge domini che verrano consentiti
        defaultCors.addAllowedOrigin("https://mywebsite.tst");
        defaultCors.addAllowedOrigin("https://mywebsite.pre");
        defaultCors.addAllowedOrigin("https://mywebsite.it");

        source.registerCorsConfiguration("/**", defaultCors);//La configurazione CORS predefinita viene poi registrata per tutte le richieste 

        /*CorsConfiguration adminCorsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        source.registerCorsConfiguration("/admin/**", adminCorsConfiguration);

        CorsConfiguration appCorsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        source.registerCorsConfiguration("/app/**", appCorsConfiguration);*/
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().permitAll();

        http.cors();
        http.csrf().disable();
    }
}
