package com.cursospring.demo_spring_rev_jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursospring.demo_spring_rev_jpa.entities.InfoAuthor;
import com.cursospring.demo_spring_rev_jpa.service.InfoAuthorService;

@RestController
@RequestMapping("info")
public class InfoAuthorController {

	@Autowired
	private InfoAuthorService service;
	
	@GetMapping("{id}")
	public InfoAuthor getById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@GetMapping("cargo/{cargo}")
	public List<InfoAuthor> getContainsCargo(@PathVariable String cargo) {
		return service.findAllContainsCargo(cargo);
	}
}
