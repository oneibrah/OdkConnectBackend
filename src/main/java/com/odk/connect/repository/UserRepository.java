package com.odk.connect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.odk.connect.enumeration.Role;
import com.odk.connect.model.Alumni;
import com.odk.connect.model.User;
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>{
	User findUserByLogin(String login);
	User findUserByEmail(String email);
	@Query(value="select u from Alumni u where u.email = :email ")
	Alumni findUserALumniByEmail(String email);
	@Query(value="select u from Alumni u where u.login = :login ")
	Alumni findUserAlumniByLogin(String login);
	List<User> findByRole(String role);

}
