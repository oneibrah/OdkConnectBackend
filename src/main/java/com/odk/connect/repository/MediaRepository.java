package com.odk.connect.repository;

import com.odk.connect.model.Media;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


=======

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
>>>>>>> c770cdb87d6cebe24fbe41c5cd9f079fc57b2203
@RepositoryRestResource
public interface MediaRepository extends JpaRepository<Media, Long> {
	Optional<Media>findByFileName(String fileName);
	List<Media>findAllByUserId(Long id);
	@Query(value="select u from Media u where u.user.role = 'ROLE_ADMIN' or  u.user.role = 'ROLE_FORMATEUR' ")
	List<Media>findAllByAdminAndFormateur();
//	@Query(value="select u from Media u where u.user.role = 'ROLE_FORMATEUR' ")
//	List<Media>findAllByFormateur();
	@Query(value="select u from Media u where u.user.role = 'ROLE_ALUM' ")
	List<Media>findAllByAlum();
}
