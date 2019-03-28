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

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Category saveCategory(@RequestBody Category category){
        categoryService.saveCategory(category);
        return category;
    }

    @GetMapping("/{nameCategory}")
    public List<Category> getCategoryId(@PathVariable String nameCategory){
        categoryService.findByName(nameCategory);
        return categoryService.findByName(nameCategory);
    }

    @GetMapping("/{id}")
    public Optional<Category> getIdCategory(@PathVariable long id){
        Category getIdCategory=categoryService.findOne(id).get();
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
        categoryService.findOne(id).get();
        updateCategory.setId(id);
        categoryService.saveCategory(updateCategory);
        return updateCategory;
    }
}
