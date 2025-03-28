package com.cursospring.demo_spring_rev_jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cursospring.demo_spring_rev_jpa.entities.InfoAuthor;
import com.cursospring.demo_spring_rev_jpa.repository.InfoAuthorRepository;

@Service
@Transactional(readOnly =true)
public class InfoAuthorService {

	@Autowired
	private InfoAuthorRepository repository;
	
	public InfoAuthor findById(Long id) {
		InfoAuthor info = new InfoAuthor();
		info.setId(id);
		return this.repository.findOne(Example.of(info)).orElseGet(InfoAuthor::new);
	}
	
	public List<InfoAuthor> findAllContainsCargo(String cargo) {
		InfoAuthor info = new InfoAuthor();
		info.setCargo(cargo);
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("cargo", ExampleMatcher.GenericPropertyMatchers.contains());
		return this.repository.findAll(Example.of(info, matcher));
	}
	
	public List<InfoAuthor> findAllCargoAndEmpresa(String cargo, String empresa) {
		InfoAuthor info = new InfoAuthor();
		info.setCargo(cargo);
		info.setBio(empresa);
		ExampleMatcher matcher = ExampleMatcher.matchingAll()
				.withMatcher("cargo", ExampleMatcher.GenericPropertyMatchers.startsWith())
				.withMatcher("bio", ExampleMatcher.GenericPropertyMatchers.contains());
		return this.repository.findAll(Example.of(info, matcher));
	}
}
