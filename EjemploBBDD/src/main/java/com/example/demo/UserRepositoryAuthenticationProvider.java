package com.example.demo;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UsuarioRepositorio userRep;

    public Authentication authentication(Authentication auth)throws AuthenticationException{
        Usuario user = userRep.findByName(auth.name()); //cargamos el usuario de la base de datos

        if(user==null){
            throw new BadCredentialsException("User not found");
        }
        String password=(String)auth.getCredentials();
        if(!new BCryptPasswordEncoder().matches(password,user.getPassword())){
            throw new BadCredentialsException("Contraseña erronea");
        }
        /* Diaposotiva seguridad 54*/
        List<GrantedAuthority> roles=new ArrayList<>();
        for(String role: user.getRol()){
            roles.add(new SimpleGrantedAuthority(role));
        }
        return new UsernamePasswordAuthenticationToken(user.getUsername(),password,role);

    }
}
