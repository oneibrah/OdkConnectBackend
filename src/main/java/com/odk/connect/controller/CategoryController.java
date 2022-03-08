package com.odk.connect.controller;


import com.odk.connect.model.CategoryForum;
import com.odk.connect.service.CategoryService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("odkConnect/category/")
public class CategoryController {


    @Autowired
    CategoryService categoryService;

    @PostMapping("ajouter")
    public CategoryForum ajouter(@RequestBody CategoryForum category){
        return categoryService.ajouterCategory(category);
    }
    @DeleteMapping("supprimer/{id}")
    Void supprimer(@PathVariable("id") Long id){
        return categoryService.supprimerCategory(id);}

}
