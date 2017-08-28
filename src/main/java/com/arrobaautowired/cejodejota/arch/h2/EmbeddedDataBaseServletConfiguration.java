package com.arrobaautowired.cejodejota.arch.h2;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jose on 28/8/17.
 * <p>
 * Levanta el servlet necesario para la consola de la base de datos embedida.
 */
@Configuration
public class EmbeddedDataBaseServletConfiguration {

    @Value("${spring.h2.console.path}")
    private String consolePath;


    @Bean
    ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings(consolePath.concat("/*"));
        return registrationBean;

    }
}
