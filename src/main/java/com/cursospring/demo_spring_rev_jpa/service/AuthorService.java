package com.cursospring.demo_spring_rev_jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cursospring.demo_spring_rev_jpa.entities.Author;
import com.cursospring.demo_spring_rev_jpa.entities.InfoAuthor;
import com.cursospring.demo_spring_rev_jpa.projection.AuthorInfoProjection;
import com.cursospring.demo_spring_rev_jpa.repository.AuthorRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository repository;

	@PersistenceContext
	private EntityManager manager;

	
	@Transactional(readOnly = false)
	public void save(Author author) {
		this.repository.save(author);
	}

	@Transactional(readOnly = false)
	public void update(Author author) {
		this.repository.save(author);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

	@Transactional(readOnly = false)
	public Author findById(long id) {
//		return this.repository.findById(id).get();
		return this.repository.findById(id).orElseThrow(
				() -> new RuntimeException("Author id= " + id + " não encontrado."));
	}

	@Transactional(readOnly = false)
	public List<Author> findAll() {
		return this.repository.findAll();
	}

	@Transactional(readOnly = false)
	public List<Author> findAllByNomeOrSobrenome(String termo) {
		return this.repository.findAllByNomeOrSobrenome("%" + termo + "%");
	}
	
	@Transactional(readOnly = true)
	public Long getTotalElements() {
		return this.repository.count();
	}
	
	@Transactional(readOnly = false)
	public Author saveInfoAutor(InfoAuthor infoAutor, Long authorId) {
		Author author = findById(authorId);
		author.setInfoAutor(infoAutor);
		return author;
	}
	
	@Transactional(readOnly = true)
	public List<Author> findByCargo(String cargo){
		return this.repository.findByCargo("%" + cargo + "%");
		
	}
	
	@Transactional(readOnly = true)
	public AuthorInfoProjection findAutorInfoById(Long id){
		String query = """
				select new AuthorInfoProjection(a.nome, a.sobrenome, a.infoAuthor.cargo, a.infoAuthor.bio)
				from Author a
				where a.id = :id
				""";
		return this.manager.createQuery(query, AuthorInfoProjection.class)
				.setParameter("id", id).getSingleResult();
	}
}
