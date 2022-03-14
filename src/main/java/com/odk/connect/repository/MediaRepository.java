package com.odk.connect.repository;

import com.odk.connect.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface MediaRepository extends JpaRepository<Media, Long> {
}
