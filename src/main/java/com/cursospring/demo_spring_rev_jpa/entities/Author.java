package com.cursospring.demo_spring_rev_jpa.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Author implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_autor", nullable = false)
	private Long id;
	
	@Column(name="nome", length = 45, nullable = false)
	private String nome;
	
	@Column(name="sobrenome", length = 45, nullable = false)
	private String sobrenome;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "id_info")
	private InfoAuthor infoAuthor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public InfoAuthor getInfoAutor() {
		return infoAuthor;
	}

	public void setInfoAutor(InfoAuthor infoAutor) {
		this.infoAuthor = infoAutor;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Author [id=" + id + "]";
	}
	
}
