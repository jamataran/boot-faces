package com.arrobaautowired.cejodejota.arch.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Web security configuration.
 * Uses in-memory user data and form login with JSF login page.
 * Special configuration is required for auto configured h2-console as this
 * is not working with frame security enabled.
 */
@EnableWebSecurity
@Configuration
@Order(0)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${spring.h2.console.path}")
    private String consolePath;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER")
                .and()
                .withUser("admin").password("admin").roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //H2-PERMITIDO
        http.authorizeRequests()
                .antMatchers(consolePath.concat(("/**")))
                .permitAll();
        http.csrf().disable();

        http.headers().frameOptions().disable();

        http
                .csrf().disable()
                .formLogin()
                .loginPage("/ui/login").permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/j_spring_security_check")
                .defaultSuccessUrl("/ui/person/list", true)
                .failureUrl("/ui/login?error=true")
                .and().logout().logoutSuccessUrl("/ui/login")
                .and()
                .antMatcher("/**")
                .authorizeRequests().anyRequest().fullyAuthenticated();




    }
}
