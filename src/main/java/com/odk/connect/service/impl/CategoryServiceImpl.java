package com.odk.connect.service.impl;


import com.odk.connect.model.CategoryForum;
import com.odk.connect.repository.CategoryRepository;
import com.odk.connect.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;



    public CategoryForum ajouterCategory(CategoryForum category) {
        return categoryRepository.save(category);
    }

    @Override
    public Void supprimerCategory(Long id) {
        return null;
    }


}
