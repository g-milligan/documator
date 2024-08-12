package gii.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        // Temporary fix - "401"
        http.csrf(httpSecurityCsrfConfigurer -> {
            httpSecurityCsrfConfigurer.disable();
        });

        http.authorizeHttpRequests(requests -> {
            // Always allow to "/access/permitted" without any authentication
            // requests.requestMatchers("/access/permitted").permitAll();
            // requests.requestMatchers("/access/restricted").authenticated();
            requests.anyRequest().authenticated();
        });

        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
