package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Autowired
    public UserRepositoryAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //public pages
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/loginerror").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();

        //private pages
        http.authorizeRequests().antMatchers("/index").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/index").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/concreteInterval").hasAnyRole("USER","ADMIN");

        //login form config
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/categories");
        http.formLogin().failureUrl("/loginerror");

        //logout page
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");

        //disable CSRF
        http.csrf().disable();
    }

    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        //DB authentication
        auth.authenticationProvider(authenticationProvider);
    }
}
