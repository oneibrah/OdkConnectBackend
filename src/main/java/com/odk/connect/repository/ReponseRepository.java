package com.odk.connect.repository;

import com.odk.connect.model.Reponse;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


=======

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
>>>>>>> c770cdb87d6cebe24fbe41c5cd9f079fc57b2203
@RepositoryRestResource
public interface ReponseRepository extends JpaRepository<Reponse, Long> {
	List<Reponse>findAllReponseByQuizId(Long id);
}
