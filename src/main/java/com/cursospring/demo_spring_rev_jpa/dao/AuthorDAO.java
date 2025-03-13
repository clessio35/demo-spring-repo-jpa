package com.cursospring.demo_spring_rev_jpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cursospring.demo_spring_rev_jpa.entities.Author;
import com.cursospring.demo_spring_rev_jpa.entities.InfoAuthor;
import com.cursospring.demo_spring_rev_jpa.projection.AuthorInfoProjection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AuthorDAO {

	@PersistenceContext
	private EntityManager manager;

	public void save(Author author) {
		this.manager.persist(author);
	}

	@Transactional(readOnly = false)
	public void update(Author author) {
		this.manager.merge(author);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		this.manager.remove(this.manager.getReference(Author.class, id));
	}

	@Transactional(readOnly = false)
	public Author findById(long id) {
		return this.manager.find(Author.class, id);
	}

	@Transactional(readOnly = false)
	public List<Author> findAll() {
		String query = "select a from Author a";
		return this.manager.createQuery(query, Author.class).getResultList();
	}

	@Transactional(readOnly = false)
	public List<Author> findAllByNomeOrSobrenome(String termo) {
		String query = "select a from Autor a " + 
						"where a.nome like :termo OR a.sobrenome like :termo";
		return this.manager.createQuery(query, Author.class)
				.setParameter("termo", "%" + termo + "%").getResultList();
	}
	
	@Transactional(readOnly = true)
	public Long getTotalElements() {
		String query = "select count(1) from Autor a ";
		return this.manager.createQuery(query, Long.class)
				.getSingleResult();
	}
	
	@Transactional(readOnly = false)
	public Author saveInfoAutor(InfoAuthor infoAutor, Long authorId) {
		Author author = findById(authorId);
		author.setInfoAutor(infoAutor);
		return author;
	}
	
	@Transactional(readOnly = true)
	public List<Author> findByCargo(String cargo){
		String query = """
				select a from Author a
				where a.infoAuthor.cargo like :cargo 
				order by a.nome asc
				""";
		return this.manager.createQuery(query, Author.class)
				.setParameter("cargo", "%" + cargo + "%").getResultList();
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
