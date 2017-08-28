package com.arrobaautowired.cejodejota.arch.h2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by jose on 28/8/17.
 */
@Configuration
@Profile("dev")
@Order(0)
public class EmmbededDataBaseSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${spring.h2.console.path}")
    private String consolePath;


    /**
     * Configuración necesaria para poder ver la consola de h2
     * Se anidará dentro de un
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(consolePath.concat(("/**")))
                .permitAll();

        http.csrf().disable();

        http.headers().frameOptions().disable();
        super.configure(http);
    }
}
