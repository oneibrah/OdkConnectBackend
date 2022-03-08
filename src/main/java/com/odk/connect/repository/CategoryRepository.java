package com.odk.connect.repository;

import com.odk.connect.model.CategoryForum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<CategoryForum, Long> {

}



