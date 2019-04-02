package com.example.demo.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository catRep;

    public Page<Category> findAll (Pageable page){
        Page<Category> cat=catRep.findAll(PageRequest.of(0,10));
        return catRep.findAll(page);
}
    
    public Optional<Category> findOne(long id){
        return catRep.findById(id);
    }

    public List<Category> findAll(){
        return catRep.findAll();
    }
    
    public List<Category> findByName(String name){
    	return catRep.findByNameCategory(name);
    }

    public void saveCategory(Category category){ catRep.save(category); }

    public void deleteCategory(long id){
        catRep.deleteById(id);
    }
    
}
