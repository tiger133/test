package com.example

import com.allanditzel.springframework.security.web.csrf.CsrfTokenResponseHeaderBindingFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.boot.autoconfigure.security.SpringBootWebSecurityConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * Created by piotr on 18.02.16.
 */
@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter
{
     @Autowired
    private SecurityUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new PlaintextPasswordEncoder())
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable() //TO-DO
        .authorizeRequests()
                .antMatchers("/js/*").permitAll()
                .anyRequest().authenticated()
                .and()
        .formLogin()
        .loginPage("/login.html")
        .defaultSuccessUrl("/index.html")
        .permitAll()
        .and()
        .logout()
        .logoutUrl("/logout.html")
        .logoutSuccessUrl("/login.html")
        .and()
        .httpBasic();
    }
}
