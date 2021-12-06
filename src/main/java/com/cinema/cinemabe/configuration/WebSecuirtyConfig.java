package com.cinema.cinemabe.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecuirtyConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder encoder;

    public WebSecuirtyConfig(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password(encoder.encode("pass")).authorities("ADMIN", "CLIENT")
                .and()
                .withUser("User").password(encoder.encode("pass")).authorities("CLIENT");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/ingredient-category").hasAuthority("ADMIN")
                .anyRequest().permitAll();
    }

}
