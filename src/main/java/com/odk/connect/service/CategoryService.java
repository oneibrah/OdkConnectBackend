package com.odk.connect.service;


import com.odk.connect.model.CategoryForum;

public interface CategoryService {

    public CategoryForum ajouterCategory(CategoryForum category);
    public Void supprimerCategory(Long id);
}
