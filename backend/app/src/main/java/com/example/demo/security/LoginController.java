package com.example.demo.security;

import com.example.demo.users.User;
import com.example.demo.users.UserComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserComponent userComponent;

    @RequestMapping("/api/login")
    public ResponseEntity<User>login(){
        if(!userComponent.isLoggedUser()){
            log.info("usuario no registrado");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }else{
            User loggedUser=userComponent.getLoggedUser();
            log.info("Entra");
            return new ResponseEntity<>(loggedUser,HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/api/logout")
    public ResponseEntity<Boolean>logout(HttpSession session){
        if(!userComponent.isLoggedUser()){
            log.info("Usuario no registrado");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }else{
            session.invalidate();
            log.info("sesion finalizada");
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
    }


}
