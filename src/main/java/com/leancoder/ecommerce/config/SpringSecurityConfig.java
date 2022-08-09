package com.leancoder.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/css/**", "/img/**", "/").permitAll()
                /* .antMatchers("/forum/**", "/users/**").authenticated() */
                .and()
/*                 .formLogin().loginPage("/login")
                .and() */
                .logout()
                .and()
                .sessionManagement().maximumSessions(1);
    }

}
