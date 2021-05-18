package br.com.casamagalhaes.controra.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@Order(1)
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${controra.http.auth.token.header.name}")
    private String tokenHeaderName;

    @Value("${controra.http.auth.token}")
    private String tokenValue;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        ApiKeyAuthFilter filter = new ApiKeyAuthFilter(tokenHeaderName);
        filter.setAuthenticationManager(authentication -> {
            String principal = (String) authentication.getPrincipal();
            if(!tokenValue.equals(principal)) {
                throw new BadCredentialsException("invalid token");
            }
            authentication.setAuthenticated(Boolean.TRUE);
            return authentication;
        });
        httpSecurity
                .authorizeRequests()
                    .antMatchers("/api-docs", "/swagger-ui.html")
                    .anonymous()
                .and()
                    .antMatcher("/api/**")
                    .csrf().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .addFilter(filter)
                .authorizeRequests();
    }
}
