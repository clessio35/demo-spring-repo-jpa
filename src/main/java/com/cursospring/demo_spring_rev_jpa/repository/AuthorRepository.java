package com.cursospring.demo_spring_rev_jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cursospring.demo_spring_rev_jpa.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

	@Query("select a from Author a where a.infoAuthor.cargo like :cargo order by a.nome asc")
	List<Author> findByCargo(@Param("cargo") String cargo);

}
