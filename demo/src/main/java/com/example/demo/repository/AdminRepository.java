package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Admin;

@RepositoryRestResource(collectionResourceRel="admin", path="admin")
public interface AdminRepository extends JpaRepository<Admin,Long> {
	


}
