package com.cursospring.demo_spring_rev_jpa.projection;

import org.springframework.beans.factory.annotation.Value;

public interface AuthorInfoProjection {

	@Value("#{target.nome + ' ' + target.sobrenome}")
	String getNomeCompleto();
	
	String getCargo();
	
	String getBio();

}
