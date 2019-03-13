package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class RestSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public UserRepositoryAuthenticationProvider userRepositoryAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.antMatcher("/api/**");

        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/login").permitAll();


        //URLS de acceso
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/categories/").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/categories/**").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/categories/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/api/categories/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/categories/**").hasRole("ADMIN");

        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/events/").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/events/**").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/events/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/api/events/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/events/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/events/{id}/image").hasRole("ADMIN");

        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/times/").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/times/**").hasAnyRole("USER","ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/times/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/api/times/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/times/**").hasRole("ADMIN");

        http.authorizeRequests().anyRequest().authenticated();

        http.csrf().disable();

        http.httpBasic();

        http.logout().logoutSuccessHandler((rq, rs, a) -> {
        });

    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.authenticationProvider(userRepositoryAuthenticationProvider);
    }
}
