package com.cursospring.demo_spring_rev_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursospring.demo_spring_rev_jpa.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	
}
