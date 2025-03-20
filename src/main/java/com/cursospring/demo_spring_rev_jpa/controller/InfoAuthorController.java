package com.cursospring.demo_spring_rev_jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursospring.demo_spring_rev_jpa.service.InfoAuthorService;

@RestController
@RequestMapping("info")
public class InfoAuthorController {

	@Autowired
	private InfoAuthorService service;
}
