package com.example.demo.api;

import com.example.demo.entities.Category;
import com.example.demo.entities.CategoryService;
import com.example.demo.entities.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")

public class CategoriesRestController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public Page<Category> getCategories(@PageableDefault(value =5) Pageable pageable){
         Page<Category>categories=categoryService.findAll(pageable);
        return categoryService.findAll(pageable);
    }

    @GetMapping("/all")
    public List<Category> getCategories(){
        List<Category>categories=categoryService.findAll();
        return categoryService.findAll();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Category saveCategory(@RequestBody Category category){
        categoryService.saveCategory(category);
        return category;
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryId(@PathVariable long id){
        categoryService.findOne(id).get();
        return categoryService.findOne(id);
    }



    @DeleteMapping("/{id}")
    public Category deleteCategory(@PathVariable long id){
        Category deleteCategory=categoryService.findOne(id).get();
        categoryService.deleteCategory(id);
        return deleteCategory;
    }

    @PutMapping("/{id}")
    public  Category updateCategory(@PathVariable long id, @RequestBody Category updateCategory){
        System.out.println("Dame el id de la categoria");
        categoryService.findOne(id).get();

        System.out.println("Actualizo el valor");
        updateCategory.setId(id);

        System.out.println("Guardo el valor");
        categoryService.saveCategory(updateCategory);
        System.out.println("Te lo devuelvo");
        return updateCategory;
    }
/*
    @GetMapping("/{nameCategory}")
    public List<Category> getCategoryId(@PathVariable String nameCategory){
        categoryService.findByName(nameCategory);
        return categoryService.findByName(nameCategory);
    }*/
}
