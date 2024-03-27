package com.amaris.usermanager.infrastructure.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/user").hasAnyRole("MODIFIER", "ADMIN","OBSERVER")
                .antMatchers(HttpMethod.GET, "/user/{userId}").hasAnyRole("MODIFIER", "ADMIN","OBSERVER")
                .antMatchers(HttpMethod.PUT, "/user").hasAnyRole("MODIFIER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/user").hasAnyRole("MODIFIER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/user/{userId}").hasRole("ADMIN")
                .anyRequest().authenticated();
    }
}
