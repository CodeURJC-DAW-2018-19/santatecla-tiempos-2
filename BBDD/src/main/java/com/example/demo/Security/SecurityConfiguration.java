package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public UserRepositoryAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //Url publicas
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/loginerror").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();

        //private pages (otras paginas) url privada
        http.authorizeRequests().anyRequest().authenticated();

        //Login here configuracion del formulario de login
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/home");
        http.formLogin().failureUrl("/loginerror");

        //logout pagina logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");

        //disable CSRF
        http.csrf().disable();
    }
/*
    //metodo para los usuarios que tienes
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        //user
        //aqui decidimmos que el usuario es user con la contraseña user con el rol usuario
        //no hace falta poner .roles("User")
        auth.inMemoryAuthentication().withUser("user").password("pass");
    }
  */
    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        //autenticacion desde la base de datos
        auth.authenticationProvider(authenticationProvider);
    }
}
