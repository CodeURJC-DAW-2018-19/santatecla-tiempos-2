package com.example.demo.Users;

import com.example.demo.Users.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserComponent {
    private Usuario user;

    public Usuario getLoggedUser(){
        return user;
    }

    public void setLoggedUser(Usuario user){
        this.user=user;
    }

    public boolean isLoggedUser(){
        return this.user != null;
    }
}
