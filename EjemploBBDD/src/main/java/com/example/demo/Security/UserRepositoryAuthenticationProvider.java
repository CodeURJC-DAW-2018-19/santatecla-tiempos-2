package com.example.demo.Security;

import com.example.demo.Users.UserComponent;
import com.example.demo.Users.Usuario;
import com.example.demo.Users.UsuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UsuarioRepositorio userRep;
    @Autowired
    private UserComponent userComponent;

   public Authentication authenticate(Authentication authentication)throws AuthenticationException {
       String username=authentication.getName();
       String password=(String)authentication.getCredentials();

       Usuario user = userRep.findByName(username);

       if(user==null){
           throw new BadCredentialsException("User dont exist");
       }

       if (!new BCryptPasswordEncoder().matches(password,user.getPassword())){
           throw new BadCredentialsException("Fail password");
       }else{
           userComponent.setLoggedUser(user);
           List<GrantedAuthority>roles=new ArrayList<>();
           for(String role:user.getRol()){
               roles.add(new SimpleGrantedAuthority(role));
           }
           return new UsernamePasswordAuthenticationToken(username,password,roles);
       }

   }



    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
