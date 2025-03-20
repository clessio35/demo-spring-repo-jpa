package com.cursospring.demo_spring_rev_jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
}
