package com.example.demo.Entidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriasService {
    @Autowired
    private CategoriasRepositorio catRep;

    //Paginacion
    @GetMapping("/practicaDAW/")
    public Page<Categorias> categoryPage (Pageable page){
        Page<Categorias> cat=catRep.findAll(PageRequest.of(0,10));
        return catRep.findAll(page);
    }

    public Optional<Categorias> findOne(long id){
        return catRep.findById(id);
    }

    public List<Categorias> findAll(){
        return catRep.findAll();
    }

    public void saveCategory(Categorias categorias){
        catRep.save(categorias);
    }

    public void deleteCategory(long id){
        catRep.deleteById(id);
    }
}
