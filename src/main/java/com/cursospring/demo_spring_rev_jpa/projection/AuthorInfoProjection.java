package com.cursospring.demo_spring_rev_jpa.projection;

public class AuthorInfoProjection {

	private String nomeCompleto;
	private String cargo;
	private String bio;

	public AuthorInfoProjection(String nome, String sobrenome, String cargo, String bio) {
		super();
		this.nomeCompleto = nome + " " + sobrenome;
		this.cargo = cargo;
		this.bio = bio;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public String getCargo() {
		return cargo;
	}

	public String getBio() {
		return bio;
	}

}
