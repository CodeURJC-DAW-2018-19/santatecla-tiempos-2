package com.example.demo;

import com.example.demo.Entidades.CategoriasRepositorio;
import com.example.demo.Entidades.EventoRepositorio;
import com.example.demo.Entidades.TiempoRepositorio;
import com.example.demo.Users.Usuario;
import com.example.demo.Users.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class BBDDinit {
    @Autowired
    private CategoriasRepositorio catRep;
    private EventoRepositorio eveRep;
    private TiempoRepositorio timeRep;
    private UsuarioRepositorio userRep;

    @PostConstruct
    public void init(){
        //Eventos,tiempo y categorias

        //usuarios
        userRep.save(new Usuario("User","pass","alumno"));
        userRep.save(new Usuario("admin","pass","profesor"));
    }
}
