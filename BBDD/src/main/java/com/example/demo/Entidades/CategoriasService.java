package com.example.demo.Entidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriasService {
    @Autowired
    private CategoriasRepositorio catRep;

    public Optional<Categorias> findOne(long id){
        return catRep.findById(id);
    }

    public List<Categorias> findAll(){
        return catRep.findAll();
    }

    public void save(Categorias categorias){
        catRep.save(categorias);
    }

    public void delete(long id){
        catRep.deleteById(id);
    }
}
