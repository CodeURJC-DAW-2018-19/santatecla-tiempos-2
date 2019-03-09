package com.example.demo.api;

import com.example.demo.entities.Category;
import com.example.demo.entities.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Collection;

@RestController
@RequestMapping("/api/categories")
public class CategoriesRestController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public Collection<Category> getCategories(){
        return categoryService.findAll();
    }

    @PostMapping("/newCategories")
    @ResponseStatus(HttpStatus.CREATED)
    public Category saveCategory(@RequestBody Category category){
        categoryService.saveCategory(category);
        return category;
    }

    @DeleteMapping("/delete/{id}")
    public Category deleteCategory(@PathVariable long id){
        Category deleteCategory=categoryService.findOne(id).get();
        categoryService.deleteCategory(id);
        return deleteCategory;
    }

    @PutMapping("/update/{id}")
    public  Category updateCategory(@PathVariable long id, @RequestBody Category updateCategory){
        categoryService.findOne(id).get();
        updateCategory.setId(id);
        categoryService.saveCategory(updateCategory);
        return updateCategory;
    }
}
