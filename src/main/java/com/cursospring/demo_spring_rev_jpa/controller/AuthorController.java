package com.cursospring.demo_spring_rev_jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cursospring.demo_spring_rev_jpa.dao.AuthorDAO;
import com.cursospring.demo_spring_rev_jpa.entities.Author;
import com.cursospring.demo_spring_rev_jpa.entities.InfoAuthor;
import com.cursospring.demo_spring_rev_jpa.projection.AuthorInfoProjection;

@RestController
@RequestMapping("autores")
public class AuthorController {

	@Autowired
	private AuthorDAO dao;

	@PostMapping
	public Author salvar(@RequestBody Author autor) {
		dao.save(autor);
		return autor;
	}

	@PutMapping
	public Author atualizar(@RequestBody Author autor) {
		dao.update(autor);
		return autor;
	}

	@DeleteMapping("{id}")
	public String remover(@PathVariable Long id) {
		dao.delete(id);
		return "Author id = " + id + " foi excluido com sucesso.";
	}

	@GetMapping("{id}")
	public Author getById(@PathVariable Long id) {
		return dao.findById(id);
	}

	@GetMapping
	public List<Author> getAll() {
		return dao.findAll();
	}

	@GetMapping("nomeOrSobrenome")
	public List<Author> getAutoresByNomeOrSobrenome(@RequestParam String termo) {
		return dao.findAllByNomeOrSobrenome(termo);
	}
	
	@GetMapping("total")
	public Long getTotalAutores() {
		return dao.getTotalElements();
	}
	
	@PutMapping("{id}/info")
	public Author salvarInfoAutor(@PathVariable Long id, @RequestBody InfoAuthor infoAutor) {
		return dao.saveInfoAutor(infoAutor, id);
	}
	
	@GetMapping("info")
	public List<Author> salvarInfoAutor(@RequestParam String cargo) {
		return dao.findByCargo(cargo);
	}
	
	@GetMapping("autor-info")
	public AuthorInfoProjection salvarInfoAutor(@RequestParam Long id) {
		return dao.findAutorInfoById(id);
	}
}
