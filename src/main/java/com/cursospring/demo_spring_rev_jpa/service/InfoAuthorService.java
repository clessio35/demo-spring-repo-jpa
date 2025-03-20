package com.cursospring.demo_spring_rev_jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cursospring.demo_spring_rev_jpa.repository.InfoAuthorRepository;

@Service
@Transactional(readOnly =true)
public class InfoAuthorService {

	@Autowired
	private InfoAuthorRepository repository;
	
}
